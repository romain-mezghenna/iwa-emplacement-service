package com.example.emplacementservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
public class Coordonnees {
    private Double latitude;
    private Double longitude;
    private Double latitudeDelta;
    private Double longitudeDelta;
}
