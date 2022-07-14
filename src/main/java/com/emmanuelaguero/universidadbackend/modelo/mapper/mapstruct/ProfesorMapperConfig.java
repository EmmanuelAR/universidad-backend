package com.emmanuelaguero.universidadbackend.modelo.mapper.mapstruct;

import com.emmanuelaguero.universidadbackend.modelo.dto.ProfesorDTO;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Profesor;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface ProfesorMapperConfig extends PersonaMapperConfig {
    @InheritConfiguration(name = "mapPersona")
    void mapProfesor(Profesor profesor, @MappingTarget ProfesorDTO profesorDTO);
}