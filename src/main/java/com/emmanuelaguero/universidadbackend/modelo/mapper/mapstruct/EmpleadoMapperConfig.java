package com.emmanuelaguero.universidadbackend.modelo.mapper.mapstruct;

import com.emmanuelaguero.universidadbackend.modelo.dto.EmpleadoDTO;
import com.emmanuelaguero.universidadbackend.modelo.dto.ProfesorDTO;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Empleado;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Profesor;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MappingTarget;

public interface EmpleadoMapperConfig extends PersonaMapperConfig{

    @InheritConfiguration(name = "mapPersona")
    void mapEmpleado(Empleado empleado, @MappingTarget EmpleadoDTO empleadoDTO);
}
