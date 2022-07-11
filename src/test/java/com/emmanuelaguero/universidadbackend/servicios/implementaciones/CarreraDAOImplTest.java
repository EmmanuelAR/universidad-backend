package com.emmanuelaguero.universidadbackend.servicios.implementaciones;

import com.emmanuelaguero.universidadbackend.datos.DatosDummy;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;
import com.emmanuelaguero.universidadbackend.repositorios.CarreraRepository;
import com.emmanuelaguero.universidadbackend.servicios.contratos.CarreraDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarreraDAOImplTest {

    CarreraDAO carreraDAO;
    CarreraRepository carreraRepository;

    @BeforeEach
    void setUp() {
        carreraRepository = mock(CarreraRepository.class);
        carreraDAO = new CarreraDAOImpl(carreraRepository);
    }

    @Test
    void findCarrerasByNombreContains() {
        //given
        String nombre = "Ingenieria";
        when(carreraRepository.findCarrerasByNombreContains(nombre))
                .thenReturn(Arrays.asList(DatosDummy.carrera01(true),DatosDummy.carrera03(true)));
        //when
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContains(nombre);
        //them
        assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01(true));
        assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03(true));
        //verifica que se use el metodo
        verify(carreraRepository).findCarrerasByNombreContains(nombre);
    }

    @Test
    void findCarrerasByNombreContainsIgnoreCase() {
        //given
        String nombre = "INgenieria";
        when(carreraRepository.findCarrerasByNombreContainsIgnoreCase(nombre))
                .thenReturn(Arrays.asList(DatosDummy.carrera01(true),DatosDummy.carrera03(true)));
        //when
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContainsIgnoreCase(nombre);
        //them
        assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01(true));
        assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03(true));
        //verifica que se use el metodo
        verify(carreraRepository).findCarrerasByNombreContainsIgnoreCase(nombre);
    }

    @Test
    void findCarrerasByCantAniosAfter() {
        //given
        Integer cantNumeros = 4;
        when(carreraRepository.findCarrerasByCantAniosAfter(cantNumeros))
                .thenReturn(Arrays.asList(DatosDummy.carrera01(true),DatosDummy.carrera03(true)));
        //when
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByCantAniosAfter(cantNumeros);
        //them
        assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01(true));
        assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03(true));
        //verifica que se use el metodo
        verify(carreraRepository).findCarrerasByCantAniosAfter(cantNumeros);
    }
}