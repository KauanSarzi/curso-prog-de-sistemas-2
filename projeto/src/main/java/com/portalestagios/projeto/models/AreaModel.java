package com.portalestagios.projeto.models;
import java.util.*;
import java.io.Serializable;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_AREA")
public class AreaModel implements Serializable {
   
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true) //nao pode haver duas areas com o mesmo nome
    private String nome;

    //RELAÇAO COM VAGA ESTAGIO
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //PARA EVITAR ERRO DE SERIALIZAÇAO E LOOPS
    @ManyToMany(mappedBy = "areas", fetch = FetchType.LAZY) //GARANTE QUE vagas NAO SERA CARREGADO AUTOMATICAMENTE QUANDO A ENTIDADE AREAMODEL FOR BUSCADA, vagas SO SERA CARREGADA QUANDO SOLICITADA
    private List<VagaEstagioModel> vagas;


    //RELAÇAO COM ESTUDANTE
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //PARA EVITAR ERRO DE SERIALIZAÇAO E LOOPS
    @ManyToMany(mappedBy = "areas", fetch = FetchType.LAZY) //MESMA COISA QUE O FETCH ACIMA
    private List<EstudanteModel> estudantes;


    public AreaModel(){}

    public AreaModel(UUID id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    //getter e setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }


    public List<VagaEstagioModel> getVagas() { return vagas; }
    public void setVagas(List<VagaEstagioModel> vagas) { this.vagas = vagas; }
    
    public List<EstudanteModel> getEstudantes() { return estudantes; }
    public void setEstudantes(List<EstudanteModel> estudantes) { this.estudantes = estudantes; }
    
    
}