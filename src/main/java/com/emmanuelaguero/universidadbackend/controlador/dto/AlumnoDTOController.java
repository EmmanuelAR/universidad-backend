package com.emmanuelaguero.universidadbackend.controlador.dto;

import com.emmanuelaguero.universidadbackend.modelo.dto.CarreraDTO;
import com.emmanuelaguero.universidadbackend.modelo.dto.PersonaDTO;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Alumno;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Persona;
import com.emmanuelaguero.universidadbackend.modelo.mapper.mapstruct.AlumnoMapper;
import com.emmanuelaguero.universidadbackend.modelo.mapper.mapstruct.CarreraMapperMS;
import com.emmanuelaguero.universidadbackend.servicios.contratos.AlumnoDAO;
import com.emmanuelaguero.universidadbackend.servicios.contratos.CarreraDAO;
import com.emmanuelaguero.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alumnos")
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "true")
public class AlumnoDTOController {

    @Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO personaDAO;
    @Autowired
    private AlumnoMapper alumnoMapper;

    @GetMapping({"/{id}"})
    public ResponseEntity<?> obtenerAlumnoPorId(@PathVariable Integer id){
        Map<String,Object> mensaje =new HashMap<>();
        Optional<Persona> encontrado = personaDAO.findById(id);
        PersonaDTO dto = alumnoMapper.mapAlumno((Alumno) encontrado.get());
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("data",dto);
        return ResponseEntity.ok(mensaje);
    }
}
