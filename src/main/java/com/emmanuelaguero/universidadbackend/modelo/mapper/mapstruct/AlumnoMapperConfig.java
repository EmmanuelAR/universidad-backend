package com.emmanuelaguero.universidadbackend.modelo.mapper.mapstruct;

import com.emmanuelaguero.universidadbackend.modelo.dto.AlumnoDTO;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Alumno;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface AlumnoMapperConfig extends PersonaMapperConfig{

    @InheritConfiguration(name ="mapPersona")//herencia
    void mapAlumno(Alumno alumno, @MappingTarget AlumnoDTO alumnoDTO);
}
