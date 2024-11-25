package com.example.emplacementservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "favoris")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Favoris {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idUser;

    @Column(nullable = false)
    private Long idEmplacement;
}
