package com.portalestagios.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portalestagios.projeto.models.Inscricao;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    
}
