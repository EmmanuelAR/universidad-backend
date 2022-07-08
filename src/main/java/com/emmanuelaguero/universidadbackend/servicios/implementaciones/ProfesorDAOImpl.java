package com.emmanuelaguero.universidadbackend.servicios.implementaciones;

import com.emmanuelaguero.universidadbackend.modelo.entidades.Persona;
import com.emmanuelaguero.universidadbackend.repositorios.AlumnoRepository;
import com.emmanuelaguero.universidadbackend.repositorios.PersonaRepository;
import com.emmanuelaguero.universidadbackend.repositorios.ProfesorRepository;
import com.emmanuelaguero.universidadbackend.servicios.contratos.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProfesorDAOImpl extends PersonaDAOImpl implements ProfesorDAO {

    @Autowired
    public ProfesorDAOImpl(@Qualifier("repositorioProfesores") PersonaRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Persona> findProfesoresByCarrera(String carrera){
        return ((ProfesorRepository) repository).findProfesoresByCarrera(carrera);
    }
}
