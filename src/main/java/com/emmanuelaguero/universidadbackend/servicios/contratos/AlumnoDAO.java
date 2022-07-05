package com.emmanuelaguero.universidadbackend.servicios.contratos;


import com.emmanuelaguero.universidadbackend.modelo.entidades.Persona;


import java.util.Optional;

public interface AlumnoDAO {
    Optional<Persona> findById(Integer id);
    Persona save(Persona persona);
    Iterable<Persona> findAll();
    void deleteById(Integer id);
}
