package com.emmanuelaguero.universidadbackend.servicios.contratos;

import com.emmanuelaguero.universidadbackend.modelo.entidades.Persona;

public interface ProfesorDAO extends PersonaDAO{

    Iterable<Persona> findProfesoresByCarrera(String carrera);
}
