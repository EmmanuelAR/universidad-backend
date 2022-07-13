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
public class CarreraController extends GenericController<Carrera,CarreraDAO>{


    @Autowired
    public CarreraController(CarreraDAO service) {
        super(service);
        nombreEntidad = "Carrera";
    }

    @GetMapping("/{codigo}")
    public Carrera getById(@PathVariable(value = "codigo",required = false) Integer id){
        Optional<Carrera> result = service.findById(id);
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
        return service.save(nuevo);
    }

    @PutMapping("/{id}")
    public Carrera updateCarrera(@PathVariable Integer id,@RequestBody Carrera carrera){
        Carrera carreraUpdate = null;
        Optional<Carrera> recuperada = service.findById(id);
        if(!recuperada.isPresent()){
            throw new BadRequestException(String.format("Carrera con ID %d no encontrada.",id));
        }
        carreraUpdate = recuperada.get();
        carreraUpdate.setCantAnios(carrera.getCantAnios());
        carreraUpdate.setCantMaterias(carrera.getCantMaterias());
        return service.save(carreraUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
