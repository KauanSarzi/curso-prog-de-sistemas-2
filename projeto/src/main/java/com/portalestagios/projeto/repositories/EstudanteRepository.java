package com.portalestagios.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portalestagios.projeto.models.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
    
}
