package com.emmanuelaguero.universidadbackend.controlador.dto;

import com.emmanuelaguero.universidadbackend.modelo.dto.CarreraDTO;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;
import com.emmanuelaguero.universidadbackend.modelo.mapper.CarreraMapper;
import com.emmanuelaguero.universidadbackend.modelo.mapper.mapstruct.CarreraMapperMS;
import com.emmanuelaguero.universidadbackend.servicios.contratos.CarreraDAO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carreras")
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "true")
@Api(value = "Acciones relacionadas con las carreras",tags = "Acciones sobre carreras.")
public class CarreraDTOController extends GenericDTOController<Carrera,CarreraDAO> {

    @Autowired
    private CarreraMapperMS mapper;

    public CarreraDTOController(CarreraDAO service) {
        super(service, "Carrera");
    }

    @GetMapping
    @ApiOperation(value = "Consultar todas las carreras.")
    @ApiResponses({
            @ApiResponse(code=200,message = "Ejecutado con exito.")
    })
    public ResponseEntity<?> obtenerCarreras(){
        Map<String,Object> mensaje =new HashMap<>();
        //uso generico
        List<Carrera> carreras = super.obtenerTodos();
        if(carreras.isEmpty()){
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("No se encontraron %ss cargadas",nombre_Entidad));
            return ResponseEntity.badRequest().body(mensaje);
        }
        List<CarreraDTO> carreraDTOS = carreras
                .stream()
                .map(mapper::mapCarrera)
                .collect(Collectors.toList());
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("data",carreraDTOS);
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Consultar carrera por ID.")
    public ResponseEntity<?> obtenerCarreraPorId(@PathVariable @ApiParam(name = "Codigo del sistema") Integer id){
        return ResponseEntity.ok("");
    }

    @PostMapping
    public ResponseEntity<?> saveCarrera(@RequestBody @ApiParam(name = "Carrera de la univiersidad") CarreraDTO carreraDTO){
        return ResponseEntity.ok("");
    }
}