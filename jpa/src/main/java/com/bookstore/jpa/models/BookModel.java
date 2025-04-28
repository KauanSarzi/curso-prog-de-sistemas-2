package com.bookstore.jpa.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity //INDICANDO QUE É UMA ENTIDADE JPA
@Table(name = "TB_BOOK") // NOME DA CLASSE QUANDO FOR MAPEADA PARA UMA TABELA NA BASE DE DADOS
public class BookModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // forma que o id vai ser gerado
    private UUID id; //CHAVE PRIMARIA DA TABELA

    @Column(nullable = false, unique = true) //crio a coluna com parametros, nesse caso se o titulo pode ser nulo ou nao e os titulos nao podem ser iguais por conta do unique
    private String title;


    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
    @ManyToOne  //fetch = FetchType.LAZY   
    @JoinColumn(name = "publisher_id") // especifica a chave estrangeira na TB BOOK RELACIONADO A TB PUBLISHER PARA FAZER O RELACIONAMENTO
    private PublisherModel publisher;


    @ManyToMany
    @JoinTable(name = "tb_book_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id") ) // crei uma tabela auxiliar pois é um many to many, e criei o nome com o id dass duass entidade relacionadas, e o tenho ambas entidades como chave estrangeira, um é a chave estrangeira do outro
    private Set<AuthorModel> authors = new HashSet<>();  // coleçao de autormodel


    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL) // CASCADE SIGNIFICA QUE SEMPRE QUE EU FIZER TRANSAÇOES NA BASE DE DADOS COM ESSES RELACIONAMENTOS AMBOS SOFRERAO ALTERAÇOES, EX: SE EU DELETAR UM LIVRO IREI DELETAR O REVIEW DESSE LIVRO AUTOMATICAMENTE
    private ReviewModel review;




    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public PublisherModel getPublisher() {
        return publisher;
    }
    
    public void setPublisher(PublisherModel publisher) {
        this.publisher = publisher;
    }


    public Set<AuthorModel> getAuthors() {
        return authors;
    }
    
    public void setAuthors(Set<AuthorModel> authors) {
        this.authors = authors;
    }


    public ReviewModel getReview() {
        return review;
    }
    
    public void setReview(ReviewModel review) {
        this.review = review;
    }
    
    
    
}