package com.portalestagios.projeto.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portalestagios.projeto.models.EmpresaModel;

public interface EmpresaRepository extends JpaRepository<EmpresaModel, UUID> {
    
}
