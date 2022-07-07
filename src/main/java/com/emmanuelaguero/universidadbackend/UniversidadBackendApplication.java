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


    public static void main(String[] args) {
        String[] beans= SpringApplication.run(UniversidadBackendApplication.class, args).getBeanDefinitionNames();

    }


}
