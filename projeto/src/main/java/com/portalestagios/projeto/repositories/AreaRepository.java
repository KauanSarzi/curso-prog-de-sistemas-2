package com.portalestagios.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portalestagios.projeto.models.Area;

public interface AreaRepository extends JpaRepository<Area, Long> {
    
}
