package com.emmanuelaguero.universidadbackend.servicios.contratos;

import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;

import java.util.Optional;

public interface CarreraDAO extends GenericoDAO<Carrera>{

    Iterable<Carrera> findCarrerasByNombreContains(String nombre);
    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
    Iterable<Carrera> findCarrerasByCantAniosAfter(Integer cantAnios);
}
