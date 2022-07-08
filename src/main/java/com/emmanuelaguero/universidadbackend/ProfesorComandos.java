package com.emmanuelaguero.universidadbackend;

import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Direccion;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Persona;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Profesor;
import com.emmanuelaguero.universidadbackend.servicios.contratos.AlumnoDAO;
import com.emmanuelaguero.universidadbackend.servicios.contratos.CarreraDAO;
import com.emmanuelaguero.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class ProfesorComandos implements CommandLineRunner {

    @Autowired
    private CarreraDAO carreraDAO;

    @Autowired
    @Qualifier("profesorDAOImpl")
    private PersonaDAO personaDAO;

    @Override
    public void run(String... args) throws Exception {

        //ADD PROFESORES
//        Persona profe1 = new Profesor(null,"Carlos","Mora","1234567",new Direccion("calle","numero","506","depa","piso","loca"),new BigDecimal("124567890.0987654321"));
//        Persona profe2 = new Profesor(null,"Ana","Rojas","89101121",new Direccion("calle","numero","506","depa","piso","loca"),new BigDecimal("124567890.0987654321"));
//        personaDAO.save(profe1);
//        personaDAO.save(profe2);
//        Iterable<Carrera> result = carreraDAO.findAll();
//        Iterable<Persona> profes = personaDAO.findAll();
//        Set<Carrera> set = new HashSet<Carrera>((Collection<? extends Carrera>) result);
//        profes.forEach(profe ->((Profesor)profe).setCarreras(set));
//        profes.forEach(alumno->personaDAO.save(alumno));



    }
}

