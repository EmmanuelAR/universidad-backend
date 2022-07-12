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

    public AlumnoController(@Qualifier("alumnoDAOImpl") PersonaDAO alumnoDao) {
        this.alumnoDao = alumnoDao;
    }

//    @GetMapping
//    public List<Persona> getAll(){
//        List<Carrera> carreras= (List<Carrera>) carreraDAO.findAll();
//        if (carreras.isEmpty()){
//            throw new BadRequestException("No existen carreras.");
//        }
//        return carreras;
//    }

//    @GetMapping("/{codigo}")
//    public Carrera getById(@PathVariable(value = "codigo",required = false) Integer id){
//        Optional<Carrera> result = carreraDAO.findById(id);
//        if(!result.isPresent()){
//            throw new BadRequestException(String.format("Carrera con ID %d no encontrada.",id));
//        }
//        return result.get();
//    }

    @PostMapping
    public Persona addAlumno(@RequestBody Persona nuevo){
        return alumnoDao.save(nuevo);
    }

//    @PutMapping("/{id}")
//    public Carrera updateCarrera(@PathVariable Integer id,@RequestBody Carrera carrera){
//        Carrera carreraUpdate = null;
//        Optional<Carrera> recuperada = carreraDAO.findById(id);
//        if(!recuperada.isPresent()){
//            throw new BadRequestException(String.format("Carrera con ID %d no encontrada.",id));
//        }
//        carreraUpdate = recuperada.get();
//        carreraUpdate.setCantAnios(carrera.getCantAnios());
//        carreraUpdate.setCantMaterias(carrera.getCantMaterias());
//        return carreraDAO.save(carreraUpdate);
//    }

//    @DeleteMapping("/{id}")
//    public void deleteById(@PathVariable Integer id){
//        carreraDAO.deleteById(id);
//    }
}