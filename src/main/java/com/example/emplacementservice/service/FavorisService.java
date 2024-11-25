package com.example.emplacementservice.service;

import com.example.emplacementservice.entity.Emplacement;
import com.example.emplacementservice.entity.Favoris;
import com.example.emplacementservice.repository.FavorisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavorisService {

    @Autowired
    private FavorisRepository favoriRepository;

    public List<Favoris> getFavorisByUser(Long idUser) {
        return favoriRepository.findByUserId(idUser);
    }

    public Favoris addFavoris(Favoris favoris) {
        return favoriRepository.save(favoris);
    }

    public Optional<Favoris> updateFavoris(Long idUser, Long idEmplacement) {
        Optional<Favoris> existingFavori = favoriRepository.findByUserIdAndEmplacementId(idUser, idEmplacement);
        if (existingFavori.isPresent()) {
            Favoris favoris = existingFavori.get();
            return Optional.of(favoriRepository.save(favoris));
        }
        return Optional.empty();
    }

    public void deleteFavoris(Long idUser, Long idEmplacement) {
        favoriRepository.findByUserIdAndEmplacementId(idUser, idEmplacement)
                .ifPresent(favoriRepository::delete);
    }
}
