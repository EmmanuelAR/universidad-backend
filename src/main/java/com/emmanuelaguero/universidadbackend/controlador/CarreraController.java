package com.emmanuelaguero.universidadbackend.controlador;

import com.emmanuelaguero.universidadbackend.exception.BadRequestException;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;
import com.emmanuelaguero.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carreras")
public class CarreraController {

    @Autowired
    private final CarreraDAO carreraDAO;

    public CarreraController(CarreraDAO carreraDAO) {
        this.carreraDAO = carreraDAO;
    }
    @GetMapping
    public List<Carrera> getAll(){
        List<Carrera> carreras= (List<Carrera>) carreraDAO.findAll();
        if (carreras.isEmpty()){
            throw new BadRequestException("No existen carreras.");
        }
        return carreras;
    }

    @GetMapping("/{codigo}")
    public Carrera getById(@PathVariable(value = "codigo",required = false) Integer id){
        Optional<Carrera> result = carreraDAO.findById(id);
        if(!result.isPresent()){
            throw new BadRequestException(String.format("Carrera con ID %d no encontrada.",id));
        }
        return result.get();
    }

    @PostMapping
    public Carrera addCarrera(@RequestBody Carrera nuevo){
        if(nuevo.getCantAnios()<0){
            throw new BadRequestException("La cantidad de años no puede ser negativo.");
        }
        if(nuevo.getCantMaterias()<0){
            throw new BadRequestException("La cantidad de materias no puede ser negativo.");
        }
        return carreraDAO.save(nuevo);
    }

    @PutMapping("/{id}")
    public Carrera updateCarrera(@PathVariable Integer id,@RequestBody Carrera carrera){
        Carrera carreraUpdate = null;
        Optional<Carrera> recuperada = carreraDAO.findById(id);
        if(!recuperada.isPresent()){
            throw new BadRequestException(String.format("Carrera con ID %d no encontrada.",id));
        }
        carreraUpdate = recuperada.get();
        carreraUpdate.setCantAnios(carrera.getCantAnios());
        carreraUpdate.setCantMaterias(carrera.getCantMaterias());
        return carreraDAO.save(carreraUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        carreraDAO.deleteById(id);
    }
}
