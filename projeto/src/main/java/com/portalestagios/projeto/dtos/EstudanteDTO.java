package com.portalestagios.projeto.dtos;

public record EstudanteDTO(
    Long id,
    String nome,
    String email,
    int anoIngresso,
    String curso,
    String matricula,
    String periodoAtual
) {}
