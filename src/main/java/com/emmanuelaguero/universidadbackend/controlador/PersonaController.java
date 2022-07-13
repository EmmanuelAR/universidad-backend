package com.emmanuelaguero.universidadbackend.controlador;

import com.emmanuelaguero.universidadbackend.exception.BadRequestException;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Persona;
import com.emmanuelaguero.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.Optional;

public class PersonaController extends GenericController<Persona, PersonaDAO> {

    public PersonaController(PersonaDAO service){
        super(service);
    }

    @GetMapping("/nombre-apellido")
    public Persona getByNombreAndApellido(@RequestParam String  nombre, @RequestParam String  apellido){
        Optional<Persona> result = service.searchByNombreAndApellido(nombre,apellido);
        if(!result.isPresent()){
            throw new BadRequestException(String.format("Alumno con nombre %s y apellido %s no encontrada.",nombre,apellido));
        }
        return result.get();
    }
}
