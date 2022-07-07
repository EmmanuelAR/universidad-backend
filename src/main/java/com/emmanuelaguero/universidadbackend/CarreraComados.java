package com.emmanuelaguero.universidadbackend;

import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;
import com.emmanuelaguero.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
public class CarreraComados implements CommandLineRunner {

    @Autowired
    private CarreraDAO servicio;

    @Override
    public void run(String... args) throws Exception {
//        Carrera micro = new Carrera(null,"Microbiologia",70,4);
//        Carrera medicina = new Carrera(null,"Medicina",80,4);
//        Carrera farma = new Carrera(null,"Farmacia",60,4);
//        Carrera IngIndustrial = new Carrera(null,"Ingenieria Industrial",40,4);
//        servicio.save(micro);
//        servicio.save(medicina);
//        servicio.save(farma);
//        servicio.save(IngIndustrial);

//        Iterable<Carrera> carreras = servicio.findCarrerasByNombreContains("ia");
//        carreras.forEach(System.out::println);
//        carreras = servicio.findCarrerasByNombreContainsIgnoreCase("Ia");
//        carreras.forEach(System.out::println);
//        carreras = servicio.findCarrerasByCantAniosAfter(2);
//        carreras.forEach(System.out::println);
    }
}
