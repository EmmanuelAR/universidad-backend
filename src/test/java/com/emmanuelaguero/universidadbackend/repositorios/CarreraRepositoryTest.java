package com.emmanuelaguero.universidadbackend.repositorios;

import com.emmanuelaguero.universidadbackend.datos.DatosDummy;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarreraRepositoryTest {

    @Autowired
    CarreraRepository carreraRepository;

    @BeforeEach
    void setUp() {
        carreraRepository.save(DatosDummy.carrera01(false));
        carreraRepository.save(DatosDummy.carrera02());
        carreraRepository.save(DatosDummy.carrera03(false));
    }

    @AfterEach
    void tearDown() {
        carreraRepository.deleteAll();
    }

    @Test
    @DisplayName("Buscar carreras por nombre")
    void findCarrerasByNombreContains() {
        //Given
//        carreraRepository.save(DatosDummy.carrera01());
//        carreraRepository.save(DatosDummy.carrera02());
//        carreraRepository.save(DatosDummy.carrera03());
        //When
        Iterable<Carrera> expected = carreraRepository.findCarrerasByNombreContains("sistemas");
        //Then
        assertThat(((List<Carrera>)expected).size()==2).isTrue();
    }

    @Test
    @DisplayName("Buscar carreras por nombre no case sensitive")
    void findCarrerasByNombreContainsIgnoreCase() {
        //given
//        carreraRepository.save(DatosDummy.carrera01());
//        carreraRepository.save(DatosDummy.carrera02());
//        carreraRepository.save(DatosDummy.carrera03());
        //When
        Iterable<Carrera> expected = carreraRepository.findCarrerasByNombreContainsIgnoreCase("sistEmas");
        //Then
        assertThat(((List<Carrera>)expected).size()==2).isTrue();
    }

    @Test
    @DisplayName("Buscar carreras mayor a X años ")
    void findCarrerasByCantAniosAfter() {
        //given
//        carreraRepository.save(DatosDummy.carrera01());
//        carreraRepository.save(DatosDummy.carrera02());
//        carreraRepository.save(DatosDummy.carrera03());
        //When
        Iterable<Carrera> expected = carreraRepository.findCarrerasByCantAniosAfter(4);
        //Then
        assertThat(((List<Carrera>)expected).size()==2).isTrue();
    }
}