package com.example.emplacementservice.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "avis")
public class Avis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvis;

    @Column(nullable = false)
    private Integer note;

    @Column(nullable = false)
    private String commentaire;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Long idEmplacement;

    @Column(nullable = false)
    private Long idUser;

    public Avis(Long idAvis, Integer note, String commentaire, LocalDate date, Long idEmplacement,Long idUser) {
        this.idAvis = idAvis;
        this.note = note;
        this.commentaire = commentaire;
        this.date = date;
        this.idEmplacement = idEmplacement;
        this.idUser = idUser;
    }

    public Avis() {

    }

    public Long getIdAvis() {
        return idAvis;
    }

    public void setIdAvis(Long idAvis) {
        this.idAvis = idAvis;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Long getIdEmplacement() {
        return idEmplacement;
    }

    public void setIdEmplacement(Long idEmplacement) {
        this.idEmplacement = idEmplacement;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
