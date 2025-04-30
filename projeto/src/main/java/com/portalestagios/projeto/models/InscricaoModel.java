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
    private UUID idinscricao;

    private Date dataInscricao;
    private String status;
    private String mensagemApresentacao;



    



    public UUID getIdinscricao() {
        return idinscricao;
    }

    public void setIdinscricao(UUID idinscricao) {
        this.idinscricao = idinscricao;
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





    
}