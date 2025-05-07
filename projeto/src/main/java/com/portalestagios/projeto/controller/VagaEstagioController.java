package com.portalestagios.projeto.controller;

import com.portalestagios.projeto.models.VagaEstagio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/vagas")
public class VagaEstagioController {
    private List<VagaEstagio> vagas;

    public VagaEstagioController() {
        vagas = new ArrayList<>();
        vagas.add(new VagaEstagio(1L, "Estágio em TI", "Suporte técnico e desenvolvimento de sistemas", true, 1200.0, 30, "Presencial"));
        vagas.add(new VagaEstagio(2L, "Estágio em Marketing", "Criação de campanhas digitais", true, 1000.0, 20, "Remoto"));
        vagas.add(new VagaEstagio(3L, "Estágio em Engenharia", "Auxílio em projetos estruturais", false, 1400.0, 25, "Híbrido"));
       
    }

    @GetMapping
    public List<VagaEstagio> getVagas() {
        return vagas;
    }
}