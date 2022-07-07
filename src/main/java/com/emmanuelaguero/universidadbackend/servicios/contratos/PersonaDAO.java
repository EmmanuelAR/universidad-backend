package com.emmanuelaguero.universidadbackend.servicios.contratos;


import com.emmanuelaguero.universidadbackend.modelo.entidades.Persona;

import java.util.Optional;

public interface PersonaDAO  extends GenericoDAO<Persona>{
    Optional<Persona> searchByNombreAndApellido(String nombre, String Apellido);
    Optional<Persona> searchByDni(String dni);
    Iterable<Persona> buscarPersonasByApellido(String apellido);
}
