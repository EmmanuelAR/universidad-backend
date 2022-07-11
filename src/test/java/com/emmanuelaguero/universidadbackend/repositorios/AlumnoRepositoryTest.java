package com.emmanuelaguero.universidadbackend.repositorios;

import com.emmanuelaguero.universidadbackend.datos.DatosDummy;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Alumno;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Persona;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AlumnoRepositoryTest {

    @Autowired
    @Qualifier("repositorioAlumnos")
    PersonaRepository alumnoRepository;
    @Autowired
    CarreraRepository carreraRepository;

    @Test
    void buscarAlumnosByCarrera(){
        //given
        Iterable<Persona> saveAlumnos =alumnoRepository.saveAll(Arrays.asList(
                DatosDummy.alumnos01(),
                DatosDummy.alumnos02(),
                DatosDummy.alumno03()));
        Carrera saveCarrera = carreraRepository.save(DatosDummy.carrera01());
        saveAlumnos.forEach(alumno -> ((Alumno)alumno).setCarrera(saveCarrera));
        alumnoRepository.saveAll(saveAlumnos);
        //when
        String carreraNombre = "Ingenieria en sistemas";
        List<Persona> expected = (List<Persona>)((AlumnoRepository)alumnoRepository).buscarAlumnosByCarrera(carreraNombre);
        //them
        assertThat(expected.size()==3).isTrue();
    }

    @Test
    void buscarAlumnosByCarreraSinValores(){
        //given
        Iterable<Persona> saveAlumnos =alumnoRepository.saveAll(Arrays.asList(
                DatosDummy.alumnos01(),
                DatosDummy.alumnos02(),
                DatosDummy.alumno03()));
        Carrera saveCarrera = carreraRepository.save(DatosDummy.carrera01());
        saveAlumnos.forEach(alumno -> ((Alumno)alumno).setCarrera(saveCarrera));
        alumnoRepository.saveAll(saveAlumnos);
        //when
        String carreraNombre = "Ingenieria en alimentos";
        List<Persona> expected = (List<Persona>)((AlumnoRepository)alumnoRepository).buscarAlumnosByCarrera(carreraNombre);
        //them
        assertThat(expected.isEmpty()).isTrue();
    }

}