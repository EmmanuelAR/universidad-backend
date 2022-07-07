package com.emmanuelaguero.universidadbackend.servicios.implementaciones;

import com.emmanuelaguero.universidadbackend.servicios.contratos.GenericoDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class GenericDAOImpl<Entidad, R extends CrudRepository<Entidad,Integer>> implements GenericoDAO<Entidad> {

    protected final R repository;

    public GenericDAOImpl(R repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Entidad> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Entidad save(Entidad newValue) {
        return repository.save(newValue);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Entidad> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
