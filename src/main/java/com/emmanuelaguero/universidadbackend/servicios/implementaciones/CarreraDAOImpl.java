package com.emmanuelaguero.universidadbackend.servicios.implementaciones;

import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;
import com.emmanuelaguero.universidadbackend.repositorios.CarreraRepository;
import com.emmanuelaguero.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class CarreraDAOImpl extends GenericDAOImpl<Carrera,CarreraRepository> implements CarreraDAO {

    public CarreraDAOImpl(CarreraRepository repository) {
        super(repository);
    }
}
