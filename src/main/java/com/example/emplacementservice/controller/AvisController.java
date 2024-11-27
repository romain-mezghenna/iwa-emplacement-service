package com.example.emplacementservice.controller;

import com.example.emplacementservice.entity.Avis;
import com.example.emplacementservice.service.AvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avis")
public class AvisController {

    private final AvisService avisService;

    @Autowired
    public AvisController(AvisService avisService) {
        this.avisService = avisService;
    }

    @GetMapping("/emplacement/{idEmplacement}")
    public List<Avis> getAvisByEmplacement(@PathVariable Long idEmplacement) {
        return avisService.getAvisByEmplacement(idEmplacement);
    }

    @PostMapping
    public Avis createAvis(@RequestBody Avis avis) {
        return avisService.addAvis(avis);
    }

    @PutMapping("/{idAvis}")
    public ResponseEntity<Avis> updateAvis(@PathVariable Long idAvis, @RequestBody Avis avisDetails) {
        Avis updatedAvis = avisService.updateAvis(idAvis, avisDetails);
        return ResponseEntity.ok(updatedAvis);
    }

    @DeleteMapping("/{idAvis}")
    public ResponseEntity<Void> deleteAvis(@PathVariable Long idAvis) {
        avisService.deleteAvis(idAvis);
        return ResponseEntity.noContent().build();
    }
}
