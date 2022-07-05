package com.emmanuelaguero.universidadbackend;

import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;
import com.emmanuelaguero.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CarreraComados implements CommandLineRunner {
    @Autowired
    private CarreraDAO servicio;

    @Override
    public void run(String... args) throws Exception {
        /*Carrera ingeSistemas = new Carrera(null,"Ingenieria en Sistemas",50,5);
        Carrera save = servicio.save(ingeSistemas);
        System.out.println(save.toString());*/

    }
}
