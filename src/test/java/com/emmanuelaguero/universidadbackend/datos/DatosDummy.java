package com.emmanuelaguero.universidadbackend.datos;

import com.emmanuelaguero.universidadbackend.modelo.entidades.*;
import com.emmanuelaguero.universidadbackend.modelo.entidades.enumeradores.TipoEmpleado;

import java.math.BigDecimal;

import static com.emmanuelaguero.universidadbackend.modelo.entidades.enumeradores.TipoEmpleado.ADMINISTRATIVO;
import static com.emmanuelaguero.universidadbackend.modelo.entidades.enumeradores.TipoEmpleado.MANTENIMIENTO;

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
    public static Persona empleado01(){return new Empleado(null,"Emmanuel","Aguero","117790953",new Direccion(), new BigDecimal(12345.56),ADMINISTRATIVO);}
    public static Persona empleado02(){return new Empleado(null,"Mariana","Jara","543213444",new Direccion(), new BigDecimal(12345.56),MANTENIMIENTO);}
    public static Persona profesor01() {return new Profesor(null, "Sonia", "Rojas", "99999888", new Direccion(), new BigDecimal(12345.56));}
    public static Persona alumnos01() {return new Alumno(null, "John", "Benites", "5432425", new Direccion());}
    public static Persona alumnos02() {return new Alumno(null, "Andres", "Benites", "3333445", new Direccion());}
    public static Persona alumno03() {return new Alumno(null, "Joaquin", "Leon", "543243333", new Direccion());}
}