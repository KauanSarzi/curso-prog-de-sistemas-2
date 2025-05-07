package com.portalestagios.projeto.models;
import jakarta.persistence.*;

import java.util.Date;
import java.lang.Long;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@Entity
@Table(name = "TB_VAGAESTAGIO")
public class VagaEstagio {
   
    @Id
    @GeneratedValue
    private Long id;

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
    private Empresa empresa;   // esse objeto tem que ter o mesmo nome do mappedby

    //RELAÇAO COM INSCRIÇAO
    @OneToMany(mappedBy = "vaga", cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
    private List<Inscricao> inscricaoVaga;

    //RELAÇAO COM AREA
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_vaga_area", joinColumns = @JoinColumn(name = "vaga_id"), inverseJoinColumns = @JoinColumn(name = "area_id"))
    private List<Area> areas;


    //CONSTRUTORES
    public VagaEstagio() {}

    public VagaEstagio(Long id, String titulo, String descricao, Boolean ativo, Double salario, int cargaHoraria, String modalidade) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.ativo = ativo;
        this.salario = salario;
        this.cargaHoraria = cargaHoraria;
        this.modalidade = modalidade;
    }


    //GETTERS E SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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
    
    public Empresa getEmpresa(){ return empresa; }
    public void setEmpresa(Empresa empresa){ this.empresa = empresa; }

    public List<Inscricao> getInscricaoVaga(){ return inscricaoVaga; }
    public void setInscricaoVaga(List<Inscricao> inscricaoVaga) { this.inscricaoVaga = inscricaoVaga; }

    public List<Area> getAreas() { return areas; }  
    public void setAreas(List<Area> areas) { this.areas = areas; }
    

    
}