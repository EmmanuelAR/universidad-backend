package com.emmanuelaguero.universidadbackend.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="carreras")
public class Carrera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name="nombre_carrera",nullable = false,unique = true,length = 80)
    private String nombre;


    @Positive(message = "El valor no puede ser negativo") //validacion valor positivo
    @Column(name="cantidad_materias")
    private Integer cantMaterias;


    @Positive(message = "El valor no puede ser negativo") //validacion valor positivo
    @Column(name="cantidad_anios")
    private Integer cantAnios;

    @Column(name="fecha_alta")
    private LocalDateTime fechaAlta;

    @Column(name="fecha_modificacion")
    private LocalDateTime fechaModificacion;


    @OneToMany(
            mappedBy = "carrera",
            fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties({"carrera"})//Elimina la relacion de carrera en alumno, evitar bucles
    private Set<Alumno> alumnos;


    @ManyToMany(
           mappedBy = "carreras",
            fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties({"carreras"})//Elimina la relacion de carrera en alumno, evitar bucles
    private Set<Profesor> profesores;


    public Carrera() {
    }

    public Carrera(Integer id, String nombre, Integer cantMaterias, Integer cantAnios) {
        this.id = id;
        this.nombre = nombre;
        this.cantMaterias = cantMaterias;
        this.cantAnios = cantAnios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantMaterias() {
        return cantMaterias;
    }

    public void setCantMaterias(Integer cantMaterias) {
        this.cantMaterias = cantMaterias;
    }

    public Integer getCantAnios() {
        return cantAnios;
    }

    public void setCantAnios(Integer cantAnios) {
        this.cantAnios = cantAnios;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantMaterias=" + cantMaterias +
                ", cantAnios=" + cantAnios +
                ", fechaAlta=" + fechaAlta +
                ", fechaUltimaModificacion=" + fechaModificacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrera carrera = (Carrera) o;
        return id.equals(carrera.id) && nombre.equals(carrera.nombre);
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
    @PrePersist
    private void antesPersistir(){
        this.fechaAlta = LocalDateTime.now();
    }
    @PreUpdate
    private void antesUpdate(){
        this.fechaModificacion = LocalDateTime.now();
    }

}
