package com.emmanuelaguero.universidadbackend.modelo.mapper.mapstruct;

import com.emmanuelaguero.universidadbackend.modelo.dto.CarreraDTO;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CarreraMapperMS {

    @Mappings({
            @Mapping(source = "id",target = "codigo"),
            @Mapping(source = "cantMaterias",target = "cantidad_materias"),
            @Mapping(source = "cantAnios",target = "cantidad_anios")
    }) //hacer le match del dto con el entyti
    CarreraDTO mapCarrera(Carrera carrera);
}
