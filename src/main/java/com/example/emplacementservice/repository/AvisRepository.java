package com.example.emplacementservice.repository;

import com.example.emplacementservice.entity.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvisRepository extends JpaRepository<Avis, Long> {
    List<Avis> findByIdEmplacement(Long idEmplacement);
    List<Avis> findByIdUser(Long idUser);
}

