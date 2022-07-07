package com.emmanuelaguero.universidadbackend.servicios.implementaciones;

import com.emmanuelaguero.universidadbackend.modelo.entidades.Persona;
import com.emmanuelaguero.universidadbackend.repositorios.PersonaRepository;
import com.emmanuelaguero.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PersonaDAOImpl extends  GenericDAOImpl<Persona, PersonaRepository> implements PersonaDAO {

    public PersonaDAOImpl(PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> searchByNombreAndApellido(String nombre, String Apellido) {
        return repository.searchByNombreAndApellido(nombre,Apellido);
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> searchByDni(String dni) {
        return repository.searchByDni(dni);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarPersonasByApellido(String apellido) {
        return repository.buscarPersonasByApellido(apellido);
    }
}
