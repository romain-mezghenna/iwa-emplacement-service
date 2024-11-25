package com.example.emplacementservice.repository;

import com.example.emplacementservice.entity.Avis;
import com.example.emplacementservice.entity.Emplacement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmplacementRepository extends JpaRepository<Emplacement, Long> {
    Optional<Emplacement> findByIdUser(Long idUser);
}

