package com.emmanuelaguero.universidadbackend.modelo.entidades;

import com.emmanuelaguero.universidadbackend.modelo.entidades.enumeradores.Pizarron;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Aula implements Serializable {

    private Integer id;
    private Integer nroAula;
    private String medidas;
    private Integer cantPupitres;
    private Pizarron pizarro;
    private LocalDateTime fechaAlta;
    private LocalDateTime fechaUltimaModificacion;

    public Aula() {
    }

    public Aula(Integer id, Integer nroAula, String medidas, Integer cantPupitres, Pizarron pizarro) {
        this.id = id;
        this.nroAula = nroAula;
        this.medidas = medidas;
        this.cantPupitres = cantPupitres;
        this.pizarro = pizarro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNroAula() {
        return nroAula;
    }

    public void setNroAula(Integer nroAula) {
        this.nroAula = nroAula;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public Integer getCantPupitres() {
        return cantPupitres;
    }

    @Override
    public String toString() {
        return "Aula{" +
                "id=" + id +
                ", nroAula=" + nroAula +
                ", medidas='" + medidas + '\'' +
                ", cantPupitres=" + cantPupitres +
                ", pizarro=" + pizarro +
                ", fechaAlta=" + fechaAlta +
                ", fechaUltimaModificacion=" + fechaUltimaModificacion +
                '}';
    }

    public void setCantPupitres(Integer cantPupitres) {
        this.cantPupitres = cantPupitres;
    }

    public Pizarron getPizarro() {
        return pizarro;
    }

    public void setPizarro(Pizarron pizarro) {
        this.pizarro = pizarro;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aula aula = (Aula) o;
        return id.equals(aula.id) && nroAula.equals(aula.nroAula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nroAula);
    }
}
