package com.emmanuelaguero.universidadbackend.repositorios;

import com.emmanuelaguero.universidadbackend.datos.DatosDummy;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Empleado;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Persona;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Profesor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class PersonaRepositoryTest {

    @Autowired
    @Qualifier("repositorioAlumnos")
    PersonaRepository alumnoRepository;

    @Autowired
    @Qualifier("repositorioProfesores")
    PersonaRepository profesorRepository;

    @Autowired
    @Qualifier("empleadoRepository")
    PersonaRepository empleadoRepository;

    @Test
    void searchByNombreAndApellido() {
        //Given
        Persona save =empleadoRepository.save(DatosDummy.empleado01());
        //When
        Optional<Persona> expected = empleadoRepository.searchByNombreAndApellido(DatosDummy.empleado01().getNombre(),DatosDummy.empleado01().getApellido());
        //
        assertThat(expected.get()).isInstanceOf(Empleado.class);
        assertThat(expected.get()).isEqualTo(save);
    }

    @Test
    void searchByDni() {
        //Given
        Persona save =profesorRepository.save(DatosDummy.profesor01());
        //When
        Optional<Persona> expected = profesorRepository.searchByDni(save.getDni());
        //Them
        assertThat(expected.get()).isInstanceOf(Profesor.class);
        assertThat(expected.get()).isEqualTo(save);
        assertThat(expected.get().getDni()).isEqualTo(save.getDni());
    }

    @Test
    void buscarPersonasByApellido() {
        //given
        Iterable<Persona> save =alumnoRepository.saveAll(Arrays.asList(
                DatosDummy.alumnos01(),
                DatosDummy.alumnos02(),
                DatosDummy.alumno03()));
        //When
        String apellido ="Benites";
        List<Persona> expected = (List<Persona>) alumnoRepository.buscarPersonasByApellido(apellido);
        //them
        assertThat(expected.size()==2).isTrue();
    }
}