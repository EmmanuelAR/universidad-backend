package com.emmanuelaguero.universidadbackend.controlador.dto;

import com.emmanuelaguero.universidadbackend.servicios.contratos.GenericoDAO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class GenericDTOController <E,S extends GenericoDAO<E>>{

    protected final S service;
    protected final String nombre_Entidad;



    public List<E> obtenerTodos(){
        return (List<E>) service.findAll();
    }

    public E obtenerPorId(Integer id){
        return (E) service.findById(id);
    }

    public E save(E valor){
        return (E) service.save(valor);
    }

    protected Map<String,Object> obtenerValidaciones(BindingResult result){
        Map<String,Object> validaciones = new HashMap<>();
        result.getFieldErrors()
                .forEach(error -> validaciones.put(error.getField(),error.getDefaultMessage()));
        return validaciones;
    }

}
