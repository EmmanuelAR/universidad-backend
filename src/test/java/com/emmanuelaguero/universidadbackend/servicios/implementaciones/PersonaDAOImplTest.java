package com.emmanuelaguero.universidadbackend.servicios.implementaciones;

import com.emmanuelaguero.universidadbackend.repositorios.AlumnoRepository;
import com.emmanuelaguero.universidadbackend.servicios.contratos.PersonaDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonaDAOImplTest {

    PersonaDAO personaDAO;
    @Mock
    AlumnoRepository alumnoRepository;

    @BeforeEach
    void setUp() {
        personaDAO = new PersonaDAOImpl(alumnoRepository);
    }

    @Test
    void searchByNombreAndApellido() {
        personaDAO.searchByNombreAndApellido(anyString(),anyString());
        //them
        verify(alumnoRepository).searchByNombreAndApellido(anyString(),anyString());
    }

    @Test
    void searchByDni() {
        personaDAO.searchByDni(anyString());
        //them
        verify(alumnoRepository).searchByDni(anyString());
    }

    @Test
    void buscarPersonasByApellido() {
        personaDAO.buscarPersonasByApellido(anyString());
        //them
        verify(alumnoRepository).buscarPersonasByApellido(anyString());
    }
}