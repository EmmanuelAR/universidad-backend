package com.emmanuelaguero.universidadbackend.modelo.mapper.mapstruct;

import com.emmanuelaguero.universidadbackend.modelo.dto.PersonaDTO;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Persona;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface PersonaMapperConfig {

    //Toda perosona entity lo va a pasar a persona DTO
     void mapPersona(Persona persona, @MappingTarget PersonaDTO personaDTO);
}
