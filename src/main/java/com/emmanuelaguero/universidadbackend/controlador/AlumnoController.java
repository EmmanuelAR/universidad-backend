package com.emmanuelaguero.universidadbackend.controlador;

import com.emmanuelaguero.universidadbackend.exception.BadRequestException;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Alumno;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Persona;
import com.emmanuelaguero.universidadbackend.servicios.contratos.CarreraDAO;
import com.emmanuelaguero.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
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
    public Persona updateAlumno(@PathVariable Integer id,@RequestBody Persona alumno){
        Persona alumnoUpdate = null;
        Optional<Persona> recuperada = service.findById(id);
        if(!recuperada.isPresent()){
            throw new BadRequestException(String.format("Alumno con ID %d no encontrado.",id));
        }
        alumnoUpdate = recuperada.get();
        alumnoUpdate.setNombre(alumno.getNombre());
        alumnoUpdate.setApellido(alumno.getApellido());
        alumnoUpdate.setDireccion(alumno.getDireccion());
        return service.save(alumnoUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }


    @PutMapping("/{idAlumno}/carrera/{idCarrera}")
    public Persona asignarCarreraAlumno(@PathVariable Integer idAlumno, @PathVariable Integer idCarrera){
        Optional<Persona> resultAlumno = service.findById(idAlumno);
        if(!resultAlumno.isPresent()){
            throw new BadRequestException(String.format("Alumno con ID %d no encontrada.",idAlumno));
        }
        Optional<Carrera> resultCarrera = carreraDAO.findById(idCarrera);
        if(!resultCarrera.isPresent()){
            throw new BadRequestException(String.format("Carrrea con ID %d no encontrada.",idCarrera));
        }
        Persona alumno = resultAlumno.get();
        Carrera carrera = resultCarrera.get();
        ((Alumno)alumno).setCarrera(carrera);
        return service.save(alumno);
    }


}