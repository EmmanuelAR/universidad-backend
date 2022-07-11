package com.emmanuelaguero.universidadbackend.datos;

import com.emmanuelaguero.universidadbackend.modelo.entidades.Carrera;

public class DatosDummy {

    public static Carrera carrera01(){
        return new Carrera(null,"Ingenieria en sistemas",50,5);
    }
    public static Carrera carrera02(){
        return new Carrera(null,"Licenciatura en sistemas",45,4);
    }
    public static Carrera carrera03(){
        return new Carrera(null,"Ingenieria en Industrial",60,5);
    }
}
