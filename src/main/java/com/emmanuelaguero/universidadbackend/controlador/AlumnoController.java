package com.emmanuelaguero.universidadbackend.controlador;

import com.emmanuelaguero.universidadbackend.exception.BadRequestException;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Alumno;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Persona;
import com.emmanuelaguero.universidadbackend.servicios.contratos.CarreraDAO;
import com.emmanuelaguero.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Deprecated //clase descontinuada
@RestController
@RequestMapping("/alumnos")
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "false")
public class AlumnoController extends PersonaController{



    private final CarreraDAO carreraDAO;


    @Autowired
    public AlumnoController(@Qualifier("alumnoDAOImpl") PersonaDAO alumnoDao, CarreraDAO carreraDAO) {
        super(alumnoDao);
        nombreEntidad="Alumno";
        this.carreraDAO = carreraDAO;
    }


    @GetMapping("/{id}")
    public Persona getById(@PathVariable(required = false) Integer id){
        Optional<Persona> result = service.findById(id);
        if(!result.isPresent()){
            throw new BadRequestException(String.format("Alumno con ID %d no encontrada.",id));
        }
        return result.get();
    }

    @PostMapping
    public Persona addAlumno(@RequestBody Persona nuevo){
        return service.save(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAlumno(@PathVariable Integer id, @RequestBody Persona alumno){
        Map<String,Object> mensaje = new HashMap<>();
        Persona alumnoUpdate = null;
        Optional<Persona> recuperada = service.findById(id);
        if(!recuperada.isPresent()){
            //throw new BadRequestException(String.format("Alumno con ID %d no encontrado.",id));
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("Alumno con ID %d no encontrado.",id));
            return ResponseEntity.badRequest().body(mensaje);
        }
        alumnoUpdate = recuperada.get();
        alumnoUpdate.setNombre(alumno.getNombre());
        alumnoUpdate.setApellido(alumno.getApellido());
        alumnoUpdate.setDireccion(alumno.getDireccion());
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("datos",service.save(alumnoUpdate));
        return ResponseEntity.ok(mensaje);

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }


    @PutMapping("/{idAlumno}/carrera/{idCarrera}")
    public ResponseEntity<?> asignarCarreraAlumno(@PathVariable Integer idAlumno, @PathVariable Integer idCarrera){
        Map<String,Object> mensaje = new HashMap<>();
        Optional<Persona> resultAlumno = service.findById(idAlumno);
        if(!resultAlumno.isPresent()){
            //throw new BadRequestException(String.format("Alumno con ID %d no encontrada.",idAlumno));
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("Alumno con ID %d no encontrada.",idAlumno));
            return ResponseEntity.badRequest().body(mensaje);
        }
        Optional<Carrera> resultCarrera = carreraDAO.findById(idCarrera);
        if(!resultCarrera.isPresent()){
            //throw new BadRequestException(String.format("Carrrea con ID %d no encontrada.",idCarrera));
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("Carrrea con ID %d no encontrada.",idCarrera));
            return ResponseEntity.badRequest().body(mensaje);
        }
        Persona alumno = resultAlumno.get();
        Carrera carrera = resultCarrera.get();
        ((Alumno)alumno).setCarrera(carrera);

        mensaje.put("success",Boolean.TRUE);
        mensaje.put("datos",service.save(alumno));
        return ResponseEntity.ok(mensaje);

    }


}