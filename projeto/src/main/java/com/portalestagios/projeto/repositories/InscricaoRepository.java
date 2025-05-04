package com.portalestagios.projeto.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portalestagios.projeto.models.InscricaoModel;

public interface InscricaoRepository extends JpaRepository<InscricaoModel, UUID> {
    
}
