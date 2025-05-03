package com.portalestagios.projeto.models;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;


@Entity
@Table(name = "TB_INSCRICAO")
public class InscricaoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private Date dataInscricao;
    private String status;
    private String mensagemApresentacao;

    @ManyToOne
    @JoinColumn(name = "vaga_id") //CHAVE ESTRANGEIRA PARA FAZER O RELACIONAMENTO
    private VagaEstagioModel vaga; // OBJETO CRIADO COM O MESMOMNOME DO MAPPED BY






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





    
}