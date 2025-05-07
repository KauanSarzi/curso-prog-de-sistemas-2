package com.portalestagios.projeto.controller;

import com.portalestagios.projeto.models.Inscricao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/api/inscricoes")
public class InscricaoController {

    private List<Inscricao> inscricoes;

    public InscricaoController() {
        inscricoes = new ArrayList<>();
        inscricoes.add(new Inscricao(1L, new Date(), "Pendente", "Gostaria muito de fazer parte da empresa."));
        inscricoes.add(new Inscricao(2L, new Date(), "Aprovada", "Acredito que posso contribuir com minhas habilidades."));
        inscricoes.add(new Inscricao(3L, new Date(), "Rejeitada", "Obrigado pela oportunidade."));
    }

    @GetMapping
    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

}
