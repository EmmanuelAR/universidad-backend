package com.emmanuelaguero.universidadbackend;

import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;
import com.emmanuelaguero.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CarreraComados implements CommandLineRunner {
    @Autowired
    private CarreraDAO servicio;

    @Override
    public void run(String... args) throws Exception {

        Optional<Carrera> recuperado = servicio.findById(1);
        if(recuperado.isPresent()){
            Carrera carrera = recuperado.get();
            System.out.println(carrera.toString());
        }else{
            System.out.println("Carrera no encontrada");
        }

    }
}
