package com.portalestagios.projeto.models;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_ESTUDANTE")
public class EstudanteModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue 
    private UUID id;

    private String nome;
    private String email;
    private int anoIngresso;
    private String curso; 


    //RELAÇAO COM INSCRIÇAO
    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL)
    private List<InscricaoModel> inscricoes;


    //RELAÇAO COM AREAS
    @ManyToMany 
    @JoinTable(name = "tb_estudante_area", joinColumns = @JoinColumn(name = "estudante_id"), inverseJoinColumns = @JoinColumn(name = "area_id"))
    private List<AreaModel> areas;



    public EstudanteModel(){

    }

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