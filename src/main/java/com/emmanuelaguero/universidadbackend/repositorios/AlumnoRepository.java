package com.emmanuelaguero.universidadbackend.repositorios;

import com.emmanuelaguero.universidadbackend.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioAlumnos")
public interface AlumnoRepository extends PersonaRepository{

    @Query("select p from Alumno p where p.carrera.nombre like %?1")
    Iterable<Persona> buscarAlumnosByCarrera(String nombre);
}
