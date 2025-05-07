package com.portalestagios.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portalestagios.projeto.models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    
}
