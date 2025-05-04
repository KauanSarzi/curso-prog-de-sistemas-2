package com.portalestagios.projeto.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table(name = "TB_EMPRESA") //NOME DA CLASSE QUANDO FOR LEVADA A TABELA DA BASE DE DADOS
public class EmpresaModel implements Serializable{
    private static final long serialVersionUID = 1L;

    
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true) //cnpj é unico, e se nao existe cnpj nao existe empresa
    private String cnpj;

    @Column(nullable = false) 
    private String nomeFantasia;
    
    @Column(nullable = false, unique = true) //email tem que ser unico de cada empresa
    //@Email, para validar o email, ver se esta no padrao de um e mail, porem precisarei adc a dependencia : spring-boot-starter-validation
    private String emailContato;

    @Column(nullable = false)
    private String endereco;

  //@Column(length = ?) decidir se iremos limitar ou nao a descriçao
    private String descricao;

    @Column(nullable = false, unique = true)
    private String telefoneContato;

    @Column(nullable = false)
    private String ramoAtuacao;


    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // O MAPPEDBY DEFINE QUEM É O RESPONSAVEL POR ESSE RELACIONAMENTO E O CASCADE FAZ COM QUE SEMPRE QUE EU FIZER ALTERAÇOES AMBAS ENTIDADES RELACIONADAS SOFRERAO ALTERAÇOES
   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)  // nesse caso é para se nao quiser retornar a empresa junto com a vaga
    private List<VagaEstagioModel> vagasPublicadas;


    

    //get e set
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }
    
    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }
    
    public String getRamoAtuacao() {
        return ramoAtuacao;
    }
    
    public void setRamoAtuacao(String ramoAtuacao) {
        this.ramoAtuacao = ramoAtuacao;
    }
    

    public List<VagaEstagioModel> getVagasPublicadas() {
        return vagasPublicadas;
    }
    
    public void setVagasPublicadas(List<VagaEstagioModel> vagasPublicadas) {
        this.vagasPublicadas = vagasPublicadas;
    }


    
}