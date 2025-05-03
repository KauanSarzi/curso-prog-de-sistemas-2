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

    private String name;

    //RELAÇAO COM VAGA ESTAGIO
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //PARA EVITAR ERRO DE SERIALIZAÇAO POIS AS VEZES A VAGA NAO ESTA DISPONIVEL
    @ManyToMany(mappedBy = "areas", fetch = FetchType.LAZY)
    private List<VagaEstagioModel> vagas;


    //RELAÇAO COM ESTUDANTE
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //PARA EVITAR ERRO DE SERIALIZAÇAO POIS AS VEZES A VAGA NAO ESTA DISPONIVEL
    @ManyToMany(mappedBy = "areas", fetch = FetchType.LAZY)
    private List<EstudanteModel> estudantes;





    //construtores
    public AreaModel(){

    }

    public AreaModel( String name) {
        this.name = name;
    }



    //getter e setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    public List<VagaEstagioModel> getVagas() {
        return vagas;
    }
    
    public void setVagas(List<VagaEstagioModel> vagas) {
        this.vagas = vagas;
    }
    
    public List<EstudanteModel> getEstudantes() {
        return estudantes;
    }
    
    public void setEstudantes(List<EstudanteModel> estudantes) {
        this.estudantes = estudantes;
    }
    
    
}