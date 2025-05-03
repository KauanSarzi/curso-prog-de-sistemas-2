package com.bookstore.jpa.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;





@Entity
@Table(name = "TB_PUBLISHER")
public class PublisherModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // forma que o id vai ser gerado
    private UUID id; //CHAVE PRIMARIA DA TABELA
    

    @Column(nullable = false, unique = true)//crio a coluna com parametros, nesse caso se o titulo pode ser nulo ou nao e os titulos nao podem ser iguais por conta do unique
    private String name;

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // PARA EVITAR ERRO DE SERIALIZAÇAO, POIS AS VEZES O LIVRO N ESTA DISPONIVEL
    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY) // MAPPED BY DEFINE QUEM É O RESPONSAVEL POR ESSE RELACIONAMENTO, O publisher FOI CRIADO LA EM BOOKMODEL
    private Set<BookModel> books = new HashSet<>(); // COLEÇAO DE LIVROS, COLEÇAO DA ENTIDADE BOOKMODEL

    //FETCH DEFINE O TIPO DE CARREGAMENTO COM FETCHTYPE, O LAZY CARREGA APENAS O NECESSARIO






    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set<BookModel> getBooks() {
        return books;
    }
    
    public void setBooks(Set<BookModel> books) {
        this.books = books;
    }
    
     
}
