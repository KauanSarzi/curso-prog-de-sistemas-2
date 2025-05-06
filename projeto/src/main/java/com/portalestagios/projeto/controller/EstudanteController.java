package com.portalestagios.projeto.controller;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portalestagios.projeto.models.EstudanteModel;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {
    private List<EstudanteModel> estudantes;

    public EstudanteController() {
        estudantes = new ArrayList<>();
        estudantes.add(new EstudanteModel(UUID.randomUUID(), "Maria", "maria@email.com", 2021, "Engenharia", "202112345", "6º período"));
        estudantes.add(new EstudanteModel(UUID.randomUUID(), "João", "joao@email.com", 2020, "Administração", "202045678", "7º período"));
        estudantes.add(new EstudanteModel(UUID.randomUUID(), "Ana", "ana@email.com", 2022, "Direito", "202289234", "4º período"));
    }

    @GetMapping("/api/estudantes")
    public List<EstudanteModel> getEstudantes() {
        return estudantes;
    }
    
}
