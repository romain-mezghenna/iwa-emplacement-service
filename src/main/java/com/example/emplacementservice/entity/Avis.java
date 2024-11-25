package com.example.emplacementservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "avis")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
