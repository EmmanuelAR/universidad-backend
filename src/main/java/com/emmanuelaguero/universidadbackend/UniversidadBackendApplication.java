package com.emmanuelaguero.universidadbackend;

import com.emmanuelaguero.universidadbackend.modelo.entidades.Alumno;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Direccion;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Persona;
import com.emmanuelaguero.universidadbackend.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UniversidadBackendApplication {
    @Autowired
    private AlumnoDAO servicioAlumnos;

    public static void main(String[] args) {
        String[] beans= SpringApplication.run(UniversidadBackendApplication.class, args).getBeanDefinitionNames();
//        for(String str: beans){
//            System.out.println(str);
//        }
    }
    @Bean
    public CommandLineRunner runner(){
        return args -> {
//            Persona alumno = new Alumno(null,"Mariana","Jara","118827365",new Direccion("Calle Estatuas","33","507","Casa","Piso 1","Alajuela"));
//            Persona result = servicioAlumnos.save(alumno);
//            System.out.println(result);

            List<Persona> alumnos= (List<Persona>) servicioAlumnos.findAll();
            alumnos.forEach(System.out::println);
        };
    }

}
