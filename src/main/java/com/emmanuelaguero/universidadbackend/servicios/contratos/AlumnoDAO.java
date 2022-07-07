package com.emmanuelaguero.universidadbackend.servicios.contratos;


import com.emmanuelaguero.universidadbackend.modelo.entidades.Persona;

public interface AlumnoDAO extends PersonaDAO{

    Iterable<Persona> buscarAlumnosByCarrera(String nombre);
}
