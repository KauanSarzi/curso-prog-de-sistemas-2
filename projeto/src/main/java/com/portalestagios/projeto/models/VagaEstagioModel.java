package com.portalestagios.projeto.models;
import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "TB_VAGAESTAGIO")
public class VagaEstagioModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private UUID idvaga;

    private String titulo;
    private String descricao;
    private Date dataPublicacao;
    private Boolean ativo;
    private Double salario;
    private int cargaHoraria;
    
 
    @ManyToOne // N vagas para 1 EMPRESA
    @JoinColumn(name = "empresa_id") //CHAVE ESTRANGEIRA PARA FAZER O RELACIONAMENTO
    private EmpresaModel empresa;   // esse objeto tem que ter o mesmo nome do mappedby



    public UUID getIdvaga() {
        return idvaga;
    }

    public void setIdvaga(UUID idvaga) {
        this.idvaga = idvaga;
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

    
}