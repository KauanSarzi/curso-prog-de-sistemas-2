package com.portalestagios.projeto.models;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_ESTUDANTE")
public class EstudanteModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue 
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true) // email deve ser unico entre os estudantes
    //@Email
    private String email;

    @Column(nullable = false)
    private int anoIngresso; 

    @Column(nullable = false)
    private String curso; 

    @Column(nullable = false, unique = true)
    private String matricula;

    @Column(nullable = false)
    private String periodoAtual;



    //RELAÇAO COM INSCRIÇAO
    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //evita com que a resposta json do estudante tenha uma lista completa de inscriçoe, e tbm evita loop
    private List<InscricaoModel> inscricoes;


    //RELAÇAO COM AREAS
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_estudante_area", joinColumns = @JoinColumn(name = "estudante_id"), inverseJoinColumns = @JoinColumn(name = "area_id"))
    private List<AreaModel> areas;



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }


    public String getMatricula() {
        return matricula;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public String getPeriodoAtual() {
        return periodoAtual;
    }
    
    public void setPeriodoAtual(String periodoAtual) {
        this.periodoAtual = periodoAtual;
    }
    

    
    public List<InscricaoModel> getInscricoes() {
        return inscricoes;
    }
    
    public void setInscricoes(List<InscricaoModel> inscricoes) {
        this.inscricoes = inscricoes;
    }

    public List<AreaModel> getAreas() {
        return areas;
    }
    
    public void setAreas(List<AreaModel> areas) {
        this.areas = areas;
    }
    


    
}