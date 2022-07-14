package com.emmanuelaguero.universidadbackend.controlador;

import com.emmanuelaguero.universidadbackend.exception.BadRequestException;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;
import com.emmanuelaguero.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    //Metodo con validaciones
    @PostMapping
    public ResponseEntity<?>  addCarrera(@Valid @RequestBody Carrera nuevo, BindingResult result){
//        if(nuevo.getCantAnios()<0){
//            throw new BadRequestException("La cantidad de años no puede ser negativo.");
//        }
//        if(nuevo.getCantMaterias()<0){
//            throw new BadRequestException("La cantidad de materias no puede ser negativo.");
//        }
        Map<String,Object> validaciones = new HashMap<>();
        if(result.hasErrors()){
            result.getFieldErrors()
                    .forEach(error -> validaciones.put(error.getField(),error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(validaciones);
        }
        return ResponseEntity.ok(service.save(nuevo));
    }

    //Ejemplo de como manejar el rensponse.
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCarrera(@PathVariable Integer id, @RequestBody Carrera carrera){
        Map<String,Object> mensaje = new HashMap<>();
        Carrera carreraUpdate = null;
        Optional<Carrera> recuperada = service.findById(id);
        if(!recuperada.isPresent()){
            //throw new BadRequestException(String.format("Carrera con ID %d no encontrada.",id));
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("Carrera con ID %d no encontrada.",id));
            return ResponseEntity.badRequest().body(mensaje);
        }
        carreraUpdate = recuperada.get();
        carreraUpdate.setCantAnios(carrera.getCantAnios());
        carreraUpdate.setCantMaterias(carrera.getCantMaterias());
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("datos",service.save(carreraUpdate));
        return ResponseEntity.ok(mensaje);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
