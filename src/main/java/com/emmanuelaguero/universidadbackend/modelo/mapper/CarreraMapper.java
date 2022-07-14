package com.emmanuelaguero.universidadbackend.modelo.mapper;

import com.emmanuelaguero.universidadbackend.modelo.dto.CarreraDTO;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;

public class CarreraMapper {

    public static CarreraDTO mapCarrera(Carrera carrera){
        CarreraDTO dto = new CarreraDTO();
        dto.setCodigo(carrera.getId());
        dto.setNombre(carrera.getNombre());
        dto.setCantidad_anios(carrera.getCantAnios());
        dto.setCantidad_materias(carrera.getCantMaterias());
        return dto;
    }
}
