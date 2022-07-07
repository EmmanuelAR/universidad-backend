package com.emmanuelaguero.universidadbackend.servicios.contratos;

import com.emmanuelaguero.universidadbackend.modelo.entidades.Persona;

import java.util.Optional;

public interface GenericoDAO<E> {
    Optional<E> findById(Integer id);
    E save(E newValue);
    Iterable<E> findAll();
    void deleteById(Integer id);
}
