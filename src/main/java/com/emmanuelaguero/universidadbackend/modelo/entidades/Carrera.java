package com.emmanuelaguero.universidadbackend.modelo.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Carrera implements Serializable {

    private Integer id;
    private String nombre;
    private Integer cantMaterias;
    private Integer cantAnios;
    private LocalDateTime fechaAlta;
    private LocalDateTime fechaModificacion;
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

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}
