package com.emmanuelaguero.universidadbackend.controlador.dto;

import com.emmanuelaguero.universidadbackend.modelo.dto.CarreraDTO;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;
import com.emmanuelaguero.universidadbackend.modelo.mapper.CarreraMapper;
import com.emmanuelaguero.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carreras")
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "true")
public class CarreraDTOController {

    @Autowired
    private CarreraDAO carreraDAO;

    @GetMapping
    public ResponseEntity<?> getAll(){
        Map<String,Object> mensaje =new HashMap<>();
        List<Carrera> carreras = (List<Carrera>) carreraDAO.findAll();
        List<CarreraDTO> carreraDTOS = carreras
                .stream()
                .map(CarreraMapper::mapCarrera)
                .collect(Collectors.toList());
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("data",carreraDTOS);
        return ResponseEntity.ok(mensaje);
    }
}