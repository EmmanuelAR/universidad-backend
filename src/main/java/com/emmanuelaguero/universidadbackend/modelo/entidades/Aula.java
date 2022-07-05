package com.emmanuelaguero.universidadbackend.modelo.entidades;

import com.emmanuelaguero.universidadbackend.modelo.entidades.enumeradores.Pizarron;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="aulas")
public class Aula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="numero_aula",nullable = false)
    private Integer nroAula;

    @Column(name="medidad_mtsxmts")
    private String medidas;

    @Column(name="cantidad_pupitres")
    private Integer cantPupitres;

    @Column(name="tipo_pizarron")
    @Enumerated(EnumType.STRING)
    private Pizarron pizarro;

    @Column(name="fecha_alta")
    private LocalDateTime fechaAlta;

    @Column(name="fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @ManyToOne(
            optional = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }

    )
    @JoinColumn(
            name = "pabellon_id",
            foreignKey = @ForeignKey(name = "FK_PABELLON_ID")
    )
    private Pabellon pabellon;

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
                ", fechaUltimaModificacion=" + fechaModificacion +
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

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Pabellon getPabellon() {
        return pabellon;
    }

    public void setPabellon(Pabellon pabellon) {
        this.pabellon = pabellon;
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
