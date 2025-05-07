package com.portalestagios.projeto.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portalestagios.projeto.models.Estudante;

@RestController
@RequestMapping("/api/estudantes")
public class EstudanteController {
    private List<Estudante> estudantes;

    public EstudanteController() {
        estudantes = new ArrayList<>();
        estudantes.add(new Estudante(1L, "Maria", "maria@email.com", 2021, "Engenharia", "202112345", "6º período"));
        estudantes.add(new Estudante(2L, "João", "joao@email.com", 2020, "Administração", "202045678", "7º período"));
        estudantes.add(new Estudante(3L, "Ana", "ana@email.com", 2022, "Direito", "202289234", "4º período"));
    }

    @GetMapping
    public List<Estudante> getEstudantes() {
        return estudantes;
    }
    
}
