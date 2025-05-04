package com.portalestagios.projeto.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portalestagios.projeto.models.AreaModel;

public interface AreaRepository extends JpaRepository<AreaModel, UUID> {
    
}
