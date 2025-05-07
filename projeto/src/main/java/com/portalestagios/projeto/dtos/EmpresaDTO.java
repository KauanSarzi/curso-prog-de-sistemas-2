package com.portalestagios.projeto.dtos;



public record EmpresaDTO(
    Long id,
    String nomeFantasia,
    String cnpj,
    String emailContato,
    String endereco,
    String descricao,
    String telefoneContato,
    String ramoAtuacao
) {}

