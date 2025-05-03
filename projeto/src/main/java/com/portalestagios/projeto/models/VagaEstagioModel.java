package com.portalestagios.projeto.models;
import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
import java.util.UUID;
import java.util.HashSet;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import java.util.List;


@Entity
@Table(name = "TB_VAGAESTAGIO")
public class VagaEstagioModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private UUID id;

    private String titulo;
    private String descricao;
    private Date dataPublicacao;
    private Boolean ativo;
    private Double salario;
    private int cargaHoraria;
    
 
    @ManyToOne // N vagas para 1 EMPRESA
    @JoinColumn(name = "empresa_id") //CHAVE ESTRANGEIRA PARA FAZER O RELACIONAMENTO
    private EmpresaModel empresa;   // esse objeto tem que ter o mesmo nome do mappedby

    @OneToMany(mappedBy = "vaga", cascade =  CascadeType.ALL)
    private List<InscricaoModel> inscricaoVaga;

    @ManyToMany
    @JoinTable(name = "tb_vaga_area", joinColumns = @JoinColumn(name = "vaga_id"), inverseJoinColumns = @JoinColumn(name = "area_id"))
    private Set<AreaModel> areas = new HashSet<>();









    public VagaEstagioModel(){

    }




    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public EmpresaModel getEmpresa(){
        return empresa;
    }

    public void setEmpresa(EmpresaModel empresa){
        this.empresa = empresa;
    }


    public List<InscricaoModel> getInscricaoVaga(){
        return inscricaoVaga;
    }

    public void setInscricaoVaga(List<InscricaoModel> inscricaoVaga) {
        this.inscricaoVaga = inscricaoVaga;
    }


    //GETT E SET AREA

    
}