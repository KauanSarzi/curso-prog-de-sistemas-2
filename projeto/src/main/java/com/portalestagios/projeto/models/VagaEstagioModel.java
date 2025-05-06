package com.portalestagios.projeto.models;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@Entity
@Table(name = "TB_VAGAESTAGIO")
public class VagaEstagioModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false) //definir se limitara tamanho ou nao
    private String descricao;

    @Column(nullable = false)
    private Date dataPublicacao;

    @Column(nullable = false)
    private Boolean ativo;

    @Column(nullable = false)
    private Double salario;

    @Column(nullable = false)
    private int cargaHoraria;

    @Column(nullable = false)
    private String modalidade; //hibrido, presencial ou online



    
 
    //RELAÇAO COM EMPRESA
    @ManyToOne // N vagas para 1 EMPRESA
    @JoinColumn(name = "empresa_id") //CHAVE ESTRANGEIRA PARA FAZER O RELACIONAMENTO
    private EmpresaModel empresa;   // esse objeto tem que ter o mesmo nome do mappedby

    //RELAÇAO COM INSCRIÇAO
    @OneToMany(mappedBy = "vaga", cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
    private List<InscricaoModel> inscricaoVaga;

    //RELAÇAO COM AREA
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_vaga_area", joinColumns = @JoinColumn(name = "vaga_id"), inverseJoinColumns = @JoinColumn(name = "area_id"))
    private List<AreaModel> areas;


    //CONSTRUTORES
    public VagaEstagioModel() {}

    public VagaEstagioModel(UUID id, String titulo, String descricao, Boolean ativo, Double salario, int cargaHoraria, String modalidade) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.ativo = ativo;
        this.salario = salario;
        this.cargaHoraria = cargaHoraria;
        this.modalidade = modalidade;
    }


    //GETTERS E SETTERS
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }

    public Double getSalario() { return salario; }
    public void setSalario(Double salario) { this.salario = salario; }

    public int getCargaHoraria() { return cargaHoraria; }
    public void setCargaHoraria(int cargaHoraria) { this.cargaHoraria = cargaHoraria; }

    public String getModalidade() { return modalidade; }
    public void setModalidade(String modalidade) { this.modalidade = modalidade; }
    
    public EmpresaModel getEmpresa(){ return empresa; }
    public void setEmpresa(EmpresaModel empresa){ this.empresa = empresa; }

    public List<InscricaoModel> getInscricaoVaga(){ return inscricaoVaga; }
    public void setInscricaoVaga(List<InscricaoModel> inscricaoVaga) { this.inscricaoVaga = inscricaoVaga; }

    public List<AreaModel> getAreas() { return areas; }  
    public void setAreas(List<AreaModel> areas) { this.areas = areas; }
    

    
}