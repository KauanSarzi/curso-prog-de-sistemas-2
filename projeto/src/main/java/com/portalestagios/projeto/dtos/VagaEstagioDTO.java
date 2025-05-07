package com.portalestagios.projeto.dtos;

import java.util.Date;

public record VagaEstagioDTO(
    Long id,
    String titulo,
    String descricao,
    Boolean ativo,
    Double salario,
    int cargaHoraria,
    String modalidade,
    Date dataPublicacao
) {}
