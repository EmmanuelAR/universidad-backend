package com.emmanuelaguero.universidadbackend.modelo.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Pabellon implements Serializable {

    private Integer id;
    private Double mt2;
    private String nombre;
    private LocalDateTime fechaAlta;
    private LocalDateTime fechaModificacion;
    private Direccion direccion;

    public Pabellon() {
    }

    public Pabellon(Integer id, Double mt2, String nombre, Direccion direccion) {
        this.id = id;
        this.mt2 = mt2;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMt2() {
        return mt2;
    }

    public void setMt2(Double mt2) {
        this.mt2 = mt2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Pabellon{" +
                "id=" + id +
                ", mt2=" + mt2 +
                ", nombre='" + nombre + '\'' +
                ", fechaAlta=" + fechaAlta +
                ", fechaUltimaModificacion=" + fechaModificacion +
                ", direccion=" + direccion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pabellon pabellon = (Pabellon) o;
        return id.equals(pabellon.id) && nombre.equals(pabellon.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}
