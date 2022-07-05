package com.emmanuelaguero.universidadbackend.servicios.implementaciones;

import com.emmanuelaguero.universidadbackend.modelo.entidades.Alumno;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Persona;
import com.emmanuelaguero.universidadbackend.repositorios.AlumnoRepository;
import com.emmanuelaguero.universidadbackend.repositorios.CarreraRepository;
import com.emmanuelaguero.universidadbackend.repositorios.PersonaRepository;
import com.emmanuelaguero.universidadbackend.servicios.contratos.AlumnoDAO;
import com.emmanuelaguero.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AlumnoDAOImpl implements AlumnoDAO {

    @Autowired
    @Qualifier("repositorioAlumnos")
    private PersonaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);

    }

    @Override
    @Transactional
    public Persona save(Persona persona) {
        return repository.save(persona);
    }
}
