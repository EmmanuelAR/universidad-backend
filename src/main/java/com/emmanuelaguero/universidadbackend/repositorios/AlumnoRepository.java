package com.emmanuelaguero.universidadbackend.repositorios;

import com.emmanuelaguero.universidadbackend.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioAlumnos")
public interface AlumnoRepository extends PersonaRepository{

    //cuando tengo un lazy load y ocupo acceder
    @Query("select p from Alumno p join fetch p.carrera c where c.nombre like %?1")
    Iterable<Persona> buscarAlumnosByCarrera(String nombre);
}
