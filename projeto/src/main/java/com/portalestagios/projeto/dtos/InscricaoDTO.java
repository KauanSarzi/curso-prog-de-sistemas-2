package com.portalestagios.projeto.dtos;

import java.util.Date;

public record InscricaoDTO(
    Long id,
    Date dataInscricao,
    String status,
    String mensagemApresentacao
) {}
