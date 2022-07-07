package com.emmanuelaguero.universidadbackend;

import com.emmanuelaguero.universidadbackend.modelo.entidades.Alumno;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Persona;
import com.emmanuelaguero.universidadbackend.servicios.contratos.AlumnoDAO;
import com.emmanuelaguero.universidadbackend.servicios.contratos.CarreraDAO;
import com.emmanuelaguero.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AlumnosComandos implements CommandLineRunner {

    @Autowired
    private CarreraDAO carreraDAO;

    @Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO personaDAO;

    @Override
    public void run(String... args) throws Exception {

       /* Optional<Carrera> result = carreraDAO.findById(2);
        Iterable<Persona> alumnos = personaDAO.findAll();
        alumnos.forEach(alumno ->((Alumno)alumno).setCarrera(result.get()));
        alumnos.forEach(alumno->personaDAO.save(alumno));*/

        //Optional<Persona> alumno_1 = personaDAO.findById(1);
//        Optional<Persona> personaNomApe = personaDAO.searchByNombreAndApellido(alumno_1.get().getNombre(),alumno_1.get().getApellido());
//        System.out.println(personaNomApe.toString());
//        Optional<Persona> personaDni = personaDAO.searchByDni(alumno_1.get().getDni());
//        System.out.println(personaDni.toString());
//        Iterable<Persona> personasApellidos  = personaDAO.buscarPersonasByApellido(alumno_1.get().getApellido());
//        personasApellidos.forEach(System.out::println);

        Optional<Carrera> result = carreraDAO.findById(2);
        Iterable<Persona> alumnosCarrera = ((AlumnoDAO)personaDAO).buscarAlumnosByCarrera(result.get().getNombre());
        alumnosCarrera.forEach(System.out::println);

    }
}
