package com.portalestagios.projeto.models;
import java.util.*;
import java.io.Serializable;
import java.util.UUID;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_AREA")
public class AreaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private UUID idArea;

    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //PARA EVITAR ERRO DE SERIALIZAÇAO POIS AS VEZES A VAGA NAO ESTA DISPONIVEL
    @ManyToMany(mappedBy = "areas", fetch = FetchType.LAZY)
    private List<VagaEstagioModel> vagas;




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

    public UUID getIdArea() {
        return idArea;
    }

    public void setIdArea(UUID idArea) {
        this.idArea = idArea;
    }


    //GET E SET VAGAS
    
}