package com.emmanuelaguero.universidadbackend.modelo.dto;

import com.emmanuelaguero.universidadbackend.modelo.entidades.Direccion;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AlumnoDTO extends PersonaDTO{

    public AlumnoDTO(Integer id, String nombre, String apellido,String dni, Direccion direccion) {
        super(id, nombre, apellido, dni, direccion);
    }
}
