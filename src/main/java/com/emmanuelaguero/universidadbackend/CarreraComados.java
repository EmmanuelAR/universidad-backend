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
        /*Carrera ingeSistemas = new Carrera(null,"Ingenieria en Sistemas",50,5);
        Carrera save = servicio.save(ingeSistemas);
        System.out.println(save.toString());*/

        Carrera carrera = null;
        Optional<Carrera> recuperado = servicio.findById(1);
        if(recuperado.isPresent()){
            carrera = recuperado.get();
            System.out.println(carrera.toString());
        }else{
            System.out.println("Carrera no encontrada");
        }

        carrera.setCantMaterias(65);
        carrera.setCantAnios(6);
        servicio.save(carrera);
        System.out.println(servicio.findById(1).orElse(new Carrera()).toString());

        servicio.deleteById(1);
        System.out.println(servicio.findById(1).orElse(new Carrera()).toString());
    }
}
