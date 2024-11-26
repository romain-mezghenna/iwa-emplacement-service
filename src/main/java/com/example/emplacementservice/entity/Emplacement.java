package com.example.emplacementservice.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "emplacement")
public class Emplacement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmplacement;

    @Column(nullable = false)
    private String localisation;

    @Column(nullable = false)
    private String caracteristique;

    @ElementCollection
    @Column(nullable = false)
    private List<String> equipements;

    @ElementCollection
    @Column(nullable = false)
    private List<String> services;

    @Column(nullable = false)
    private Double tarif;

    @Column(nullable = false)
    private Boolean disponible;

    @Column(nullable = false)
    private Long idUser;

    private Double moyenneAvis;

    @ElementCollection
    @Column(nullable = true)
    private List<String> photos;

    @Embedded
    private Coordonnees coordonnees;

    public Long getIdEmplacement() {
        return idEmplacement;
    }

    public void setIdEmplacement(Long idEmplacement) {
        this.idEmplacement = idEmplacement;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(String caracteristique) {
        this.caracteristique = caracteristique;
    }

    public List<String> getEquipements() {
        return equipements;
    }

    public void setEquipements(List<String> equipements) {
        this.equipements = equipements;
    }

    public Double getTarif() {
        return tarif;
    }

    public void setTarif(Double tarif) {
        this.tarif = tarif;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Double getMoyenneAvis() {
        return moyenneAvis;
    }

    public void setMoyenneAvis(Double moyenneAvis) {
        this.moyenneAvis = moyenneAvis;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }
}
