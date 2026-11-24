package com.mehdi.musees.entities;

import java.util.Date;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
public class Oeuvre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOeuvre;

    private String titreOeuvre;
    private Integer anneeCreation;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateAcquisition;

    @ManyToOne
    @JoinColumn(name = "musee_id")
    private Musee musee;

    public Oeuvre() {}

    public Oeuvre(Long idOeuvre, String titreOeuvre, Integer anneeCreation, Date dateAcquisition, Musee musee) {
        this.idOeuvre = idOeuvre;
        this.titreOeuvre = titreOeuvre;
        this.anneeCreation = anneeCreation;
        this.dateAcquisition = dateAcquisition;
        this.musee = musee;
    }

    public Long getIdOeuvre() {
        return idOeuvre;
    }

    public void setIdOeuvre(Long idOeuvre) {
        this.idOeuvre = idOeuvre;
    }

    public String getTitreOeuvre() {
        return titreOeuvre;
    }

    public void setTitreOeuvre(String titreOeuvre) {
        this.titreOeuvre = titreOeuvre;
    }

    public Integer getAnneeCreation() {
        return anneeCreation;
    }

    public void setAnneeCreation(Integer anneeCreation) {
        this.anneeCreation = anneeCreation;
    }

    public Date getDateAcquisition() {
        return dateAcquisition;
    }

    public void setDateAcquisition(Date dateAcquisition) {
        this.dateAcquisition = dateAcquisition;
    }

    public Musee getMusee() {
        return musee;
    }

    public void setMusee(Musee musee) {
        this.musee = musee;
    }

    @Override
    public String toString() {
        return "Oeuvre{" +
                "idOeuvre=" + idOeuvre +
                ", titreOeuvre='" + titreOeuvre + '\'' +
                ", anneeCreation=" + anneeCreation +
                ", dateAcquisition=" + dateAcquisition +
                ", musee=" + musee +
                '}';
    }
}