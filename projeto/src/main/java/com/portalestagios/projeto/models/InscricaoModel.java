package com.portalestagios.projeto.models;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "TB_INSCRICAO")
public class InscricaoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue 
    private UUID id;


    @Column(nullable = false) 
    private Date dataInscricao;

    @Column(nullable = false)
    //@Enumerated(EnumType.STRING) avaliar para ver se o jpa suporta 
    private String status;

    //@Column(length= 500) define o tamanho maximo da mensagem
    private String mensagemApresentacao;

    //RELAÇAO COM VAGA
    @ManyToOne
    @JoinColumn(name = "vaga_id") //CHAVE ESTRANGEIRA PARA FAZER O RELACIONAMENTO
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
    private VagaEstagioModel vaga; // OBJETO CRIADO COM O MESMOMNOME DO MAPPED BY

    
    //RELAÇAO COM ESTUDANTE
    @ManyToOne
    @JoinColumn(name = "estudante_id") //CHAVE ESTRANGEIRA PARA FAZER O RELACIONAMENTO
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
    private EstudanteModel estudante; // OBJETO CRIADO COM O MESMOMNOME DO MAPPED BY

    


   




    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMensagemApresentacao() {
        return mensagemApresentacao;
    }

    public void setMensagemApresentacao(String mensagemApresentacao) {
        this.mensagemApresentacao = mensagemApresentacao;
    }

    public VagaEstagioModel getVaga(){
        return vaga;
    }

    public void setVaga(VagaEstagioModel vaga){
        this.vaga = vaga;
        
    }

    public EstudanteModel getEstudante() {
        return estudante;
    }
    
    public void setEstudante(EstudanteModel estudante) {
        this.estudante = estudante;
    }
    





    
}