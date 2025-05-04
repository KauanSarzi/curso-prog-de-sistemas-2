package com.portalestagios.projeto.dtos;

import java.util.UUID;

public record EmpresaDTO(
    UUID id,
    String nomeFantasia,
    String cnpj,
    String emailContato,
    String endereco,
    String descricao,
    String telefoneContato,
    String ramoAtuacao
) {}

