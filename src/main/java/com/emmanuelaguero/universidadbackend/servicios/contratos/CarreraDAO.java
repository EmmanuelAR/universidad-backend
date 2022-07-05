package com.emmanuelaguero.universidadbackend.servicios.contratos;

import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;

import java.util.Optional;

public interface CarreraDAO {
    Optional<Carrera> findById(Integer id);
    Carrera save(Carrera carrera);
    Iterable<Carrera> findAll();
    void deleteById(Integer id);
}
