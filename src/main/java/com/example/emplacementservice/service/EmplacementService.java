package com.example.emplacementservice.service;

import com.example.emplacementservice.entity.Emplacement;
import com.example.emplacementservice.repository.EmplacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmplacementService {

    private final EmplacementRepository emplacementRepository;

    @Autowired
    public EmplacementService(EmplacementRepository emplacementRepository) {
        this.emplacementRepository = emplacementRepository;
    }

    public List<Emplacement> getAllEmplacements() {
        return emplacementRepository.findAll();
    }

    public Optional<Emplacement> getEmplacementById(Long idEmplacement) {
        return emplacementRepository.findById(idEmplacement);
    }

    public Optional<Emplacement> getEmplacementByIdUser(Long idUser) {
        return emplacementRepository.findByIdUser(idUser);
    }

    public Emplacement createEmplacement(Emplacement emplacement) {
        return emplacementRepository.save(emplacement);
    }

    public Emplacement updateEmplacement(Long idEmplacement, Emplacement emplacementDetails) {
        Emplacement emplacement = emplacementRepository.findById(idEmplacement)
                .orElseThrow(() -> new RuntimeException("Emplacement non trouvé"));

        emplacement.setLocalisation(emplacementDetails.getLocalisation());
        emplacement.setCaracteristique(emplacementDetails.getCaracteristique());
        emplacement.setEquipements(emplacementDetails.getEquipements());
        emplacement.setServices(emplacementDetails.getServices());
        emplacement.setTarif(emplacementDetails.getTarif());
        emplacement.setDisponible(emplacementDetails.getDisponible());
        emplacement.setIdUser(emplacementDetails.getIdUser());
        emplacement.setMoyenneAvis(emplacementDetails.getMoyenneAvis());
        emplacement.setPhotos(emplacementDetails.getPhotos());
        emplacement.setCoordonnees(emplacementDetails.getCoordonnees());

        return emplacementRepository.save(emplacement);
    }

    public void deleteEmplacement(Long idEmplacement) {
        emplacementRepository.deleteById(idEmplacement);
    }
}
