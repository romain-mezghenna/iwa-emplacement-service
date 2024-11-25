package com.example.emplacementservice.service;

import com.example.emplacementservice.entity.Avis;
import com.example.emplacementservice.repository.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvisService {

    private final AvisRepository avisRepository;

    @Autowired
    public AvisService(AvisRepository avisRepository) {
        this.avisRepository = avisRepository;
    }

    // Méthode pour récupérer les avis par id_emplacement
    public List<Avis> getAvisByEmplacement(Long idEmplacement) {
        return avisRepository.findByIdEmplacement(idEmplacement);
    }

    public Avis addAvis(Avis avis) {
        return avisRepository.save(avis);
    }

    public Avis updateAvis(Long idAvis, Avis avisDetails) {
        Avis avis = avisRepository.findById(idAvis)
                .orElseThrow(() -> new RuntimeException("Avis non trouvé"));

        avis.setNote(avisDetails.getNote());
        avis.setCommentaire(avisDetails.getCommentaire());
        avis.setDate(avisDetails.getDate());
        avis.setIdEmplacement(avisDetails.getIdEmplacement());

        return avisRepository.save(avis);
    }

    public void deleteAvis(Long idAvis) {
        avisRepository.deleteById(idAvis);
    }
}
