package com.bookstore.jpa.models;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_REVIEW")
public class ReviewModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // forma que o id vai ser gerado
    private UUID id;

    @Column(nullable = false, unique = true) //crio a coluna com parametros, nesse caso se o titulo pode ser nulo ou nao e os titulos nao podem ser iguais por conta do unique
    private String comment;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // PARA EVITAR ERRO DE SERIALIZAÇAO, POIS AS VEZES O LIVRO N ESTA DISPONIVEL
    @OneToOne
    @JoinColumn(name = "book_id")
    private BookModel book; // book é o nome do relacionamento criado no mapped by em bookmodel



    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getComment() {
        return comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }

    public BookModel getBook() {
        return book;
    }
    
    public void setBook(BookModel book) {
        this.book = book;
    }
    

    
}