package com.example.emplacementservice.controller;

import com.example.emplacementservice.entity.Emplacement;
import com.example.emplacementservice.entity.Favoris;
import com.example.emplacementservice.service.FavorisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/favoris")
public class FavorisController {

    @Autowired
    private FavorisService favorisService;

    // Récupérer tous les favoris d'un utilisateur
    @GetMapping("/{idUser}")
    public ResponseEntity<List<Favoris>> getFavorisByUser(@PathVariable Long idUser) {
        List<Favoris> favoris = favorisService.getFavorisByUser(idUser);
        return ResponseEntity.ok(favoris);
    }

    // Ajouter un favori
    @PostMapping
    public Favoris createFavoris(@RequestBody Favoris favoris) {
        return favorisService.addFavoris(favoris);
    }

    // Mettre à jour un favori (si besoin, par ex. modifier des détails)
    @PutMapping("/{idUser}/update")
    public ResponseEntity<Favoris> updateFavoris(@PathVariable Long idUser, @RequestParam Long idEmplacement) {
        Optional<Favoris> favoris = favorisService.updateFavoris(idUser, idEmplacement);
        return favoris.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Supprimer un favori
    @DeleteMapping("/{idUser}/delete")
    public ResponseEntity<Void> deleteFavoris(@PathVariable Long idUser, @RequestParam Long idEmplacement) {
        favorisService.deleteFavoris(idUser, idEmplacement);
        return ResponseEntity.noContent().build();
    }
}
