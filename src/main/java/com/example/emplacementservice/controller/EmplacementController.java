package com.example.emplacementservice.controller;

import com.example.emplacementservice.entity.Emplacement;
import com.example.emplacementservice.service.EmplacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emplacements")
public class EmplacementController {

    private final EmplacementService emplacementService;

    @Autowired
    public EmplacementController(EmplacementService emplacementService) {
        this.emplacementService = emplacementService;
    }

    @GetMapping
    public List<Emplacement> getAllEmplacements() {
        return emplacementService.getAllEmplacements();
    }

    @GetMapping("/{idEmplacement}")
    public ResponseEntity<Emplacement> getEmplacementById(@PathVariable Long idEmplacement) {
        return emplacementService.getEmplacementById(idEmplacement)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<Emplacement> getEmplacementByIdUser(@PathVariable Long idUser) {
        return emplacementService.getEmplacementByIdUser(idUser)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Emplacement createEmplacement(@RequestBody Emplacement emplacement) {
        return emplacementService.createEmplacement(emplacement);
    }

    @PutMapping("/{idEmplacement}")
    public ResponseEntity<Emplacement> updateEmplacement(@PathVariable Long idEmplacement, @RequestBody Emplacement emplacementDetails) {
        Emplacement updatedEmplacement = emplacementService.updateEmplacement(idEmplacement, emplacementDetails);
        return ResponseEntity.ok(updatedEmplacement);
    }

    @DeleteMapping("/{idEmplacement}")
    public ResponseEntity<Void> deleteEmplacement(@PathVariable Long idEmplacement) {
        emplacementService.deleteEmplacement(idEmplacement);
        return ResponseEntity.noContent().build();
    }
}
