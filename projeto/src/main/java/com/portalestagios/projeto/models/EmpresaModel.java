package com.portalestagios.projeto.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_EMPRESA") //NOME DA CLASSE QUANDO FOR LEVADA A TABELA DA BASE DE DADOS
public class EmpresaModel implements Serializable{
    private static final long serialVersionUID = 1L;

    
    @Id
    @GeneratedValue
    private UUID idempresa;

    //@Column
    private String cnpj;

    //@Column
    private String nomeFantasia;
    
    //@Column
    private String emailContato;

   //@Column(nullable = false, unique = true) //crio a coluna com parametros, nesse caso o endereço nao pode ser nulo e os endereços nao podem ser iguais por conta do unique
    private String endereco;

  //@Column(nullable = false, unique = true)
    private String descricao;


    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL) // O MAPPEDBY DEFINE QUEM É O RESPONSAVEL POR ESSE RELACIONAMENTO E O CASCADE FAZ COM QUE SEMPRE QUE EU FIZER ALTERAÇOES AMBAS ENTIDADES RELACIONADAS SOFRERAO ALTERAÇOES
    private List<VagaEstagioModel> vagasPublicadas;


    

    // CONSTRUTORES
    public EmpresaModel() {
    }

    public EmpresaModel(String nomeFantasia, String cnpj, String emailContato, String endereco, String descricao) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.emailContato = emailContato;
        this.endereco = endereco;
        this.descricao = descricao;
    }

    //get e set
    public UUID getIdEmpresa() {
        return idempresa;
    }

    public void setIdEmpresa(UUID idempresa) {
        this.idempresa = idempresa;
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


    public List<VagaEstagioModel> getVagasPublicadas() {
        return vagasPublicadas;
    }
    
    public void setVagasPublicadas(List<VagaEstagioModel> vagasPublicadas) {
        this.vagasPublicadas = vagasPublicadas;
    }


    
}