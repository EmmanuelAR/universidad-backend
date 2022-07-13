package com.emmanuelaguero.universidadbackend.controlador;

import com.emmanuelaguero.universidadbackend.exception.BadRequestException;
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
public class AlumnoController {


    private final PersonaDAO alumnoDao;


    @Autowired
    public AlumnoController(@Qualifier("alumnoDAOImpl") PersonaDAO alumnoDao) {
        this.alumnoDao = alumnoDao;
    }


    @GetMapping
    public List<Persona> getAll(){
        List<Persona> personas= (List<Persona>) alumnoDao.findAll();
        if (personas.isEmpty()){
            throw new BadRequestException("No existen alumnos.");
        }
        return personas;
    }

    @GetMapping("/{id}")
    public Persona getById(@PathVariable(required = false) Integer id){
        Optional<Persona> result = alumnoDao.findById(id);
        if(!result.isPresent()){
            throw new BadRequestException(String.format("Alumno con ID %d no encontrada.",id));
        }
        return result.get();
    }

    @PostMapping
    public Persona addAlumno(@RequestBody Persona nuevo){
        return alumnoDao.save(nuevo);
    }

    @PutMapping("/{id}")
    public Persona updateAlumno(@PathVariable Integer id,@RequestBody Persona alumno){
        Persona alumnoUpdate = null;
        Optional<Persona> recuperada = alumnoDao.findById(id);
        if(!recuperada.isPresent()){
            throw new BadRequestException(String.format("Alumno con ID %d no encontrado.",id));
        }
        alumnoUpdate = recuperada.get();
        alumnoUpdate.setNombre(alumno.getNombre());
        alumnoUpdate.setApellido(alumno.getApellido());
        alumnoUpdate.setDireccion(alumno.getDireccion());
        return alumnoDao.save(alumnoUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        alumnoDao.deleteById(id);
    }
}