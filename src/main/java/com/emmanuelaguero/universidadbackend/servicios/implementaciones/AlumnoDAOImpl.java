package com.emmanuelaguero.universidadbackend.servicios.implementaciones;


import com.emmanuelaguero.universidadbackend.modelo.entidades.Persona;

import com.emmanuelaguero.universidadbackend.repositorios.PersonaRepository;
import com.emmanuelaguero.universidadbackend.servicios.contratos.AlumnoDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service

public class AlumnoDAOImpl extends GenericDAOImpl<Persona,PersonaRepository> implements AlumnoDAO {

    @Autowired
    public AlumnoDAOImpl(@Qualifier("repositorioAlumnos")PersonaRepository repository) {
        super(repository);
    }

}
