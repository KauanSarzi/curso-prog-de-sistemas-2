package com.portalestagios.projeto.models;


import java.lang.Long;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_USER")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String senha;

    // @Enumerated(EnumType.STRING)
    // @Column(nullable = false)
   //  private TipoAcesso tipoacesso; ou collections singleton

    public User(){}

    public User(Long id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }


  // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

}
