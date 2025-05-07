package com.portalestagios.projeto.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.lang.Long;





@Entity
@Table(name = "TB_EMPRESA") //NOME DA CLASSE QUANDO FOR LEVADA A TABELA DA BASE DE DADOS
public class Empresa {


    
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true) //cnpj é unico, e se nao existe cnpj nao existe empresa
    private String cnpj;

    @Column(nullable = false) 
    private String nomeFantasia;
    
    @Column(nullable = false, unique = true) //email tem que ser unico de cada empresa
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
    private List<VagaEstagio> vagasPublicadas;


    

    public Empresa(){
    }

    public Empresa(Long id, String cnpj, String nomeFantasia, String emailContato, String endereco, String descricao, String telefoneContato, String ramoAtuacao) {
        this.id = id;
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.emailContato = emailContato;
        this.endereco = endereco;
        this.descricao = descricao;
        this.telefoneContato = telefoneContato;
        this.ramoAtuacao = ramoAtuacao;
    }





    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getNomeFantasia() { return nomeFantasia; }
    public void setNomeFantasia(String nomeFantasia) { this.nomeFantasia = nomeFantasia; }

    public String getEmailContato() { return emailContato; }
    public void setEmailContato(String emailContato) { this.emailContato = emailContato; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getTelefoneContato() { return telefoneContato; }
    public void setTelefoneContato(String telefoneContato) { this.telefoneContato = telefoneContato; }
    
    public String getRamoAtuacao() { return ramoAtuacao; }
    public void setRamoAtuacao(String ramoAtuacao) { this.ramoAtuacao = ramoAtuacao; }

    public List<VagaEstagio> getVagasPublicadas() { return vagasPublicadas; }  
    public void setVagasPublicadas(List<VagaEstagio> vagasPublicadas) { this.vagasPublicadas = vagasPublicadas; }


    
}