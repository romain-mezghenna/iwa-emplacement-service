package com.example.emplacementservice.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "emplacement")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
