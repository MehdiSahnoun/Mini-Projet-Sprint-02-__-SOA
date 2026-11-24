package com.mehdi.musees.entities;


import java.util.Date;
import java.util.List;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Musee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMusee;

    private String nomMusee;
    private Double superficieMusee;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateInauguration;

    @OneToMany(mappedBy = "musee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Oeuvre> oeuvres;

    public Musee() {}

    public Long getIdMusee() { return idMusee; }
    public void setIdMusee(Long idMusee) { this.idMusee = idMusee; }
    public String getNomMusee() { return nomMusee; }
    public void setNomMusee(String nomMusee) { this.nomMusee = nomMusee; }
    public Double getSuperficieMusee() { return superficieMusee; }
    public void setSuperficieMusee(Double superficieMusee) { this.superficieMusee = superficieMusee; }
    public Date getDateInauguration() { return dateInauguration; }
    public void setDateInauguration(Date dateInauguration) { this.dateInauguration = dateInauguration; }
    public List<Oeuvre> getOeuvres() { return oeuvres; }
    public void setOeuvres(List<Oeuvre> oeuvres) { this.oeuvres = oeuvres; }
}
