package com.bookstore.jpa.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookstore.jpa.models.BookModel;

import java.util.List;
import java.util.UUID;


public interface BookRepository extends JpaRepository<BookModel, UUID> {

    BookModel findBookModelByTitle(String Title);
    
    @Query(value = "SELECT * FROM tb_book WHERE publisher_id = :id", nativeQuery = true)
    List<BookModel> findBooksByPublisherId(@Param("id") UUID id);



//1. @Query(...)
//Essa anotação é usada no Spring Data JPA para declarar uma consulta personalizada que será executada quando o método for chamado.

//value = "SELECT * FROM tb_book WHERE publisher_id = :id":
//É uma consulta SQL nativa, ou seja, escrita diretamente em SQL (não é JPQL).
//Está buscando todos os registros (*) da tabela tb_book cujo campo publisher_id é igual ao valor passado por parâmetro (:id).

//nativeQuery = true:
//Indica que essa é uma consulta nativa (SQL puro), e não JPQL.
//Isso é necessário quando você quer usar sintaxe ou recursos específicos do banco de dados.



//2. List<BookModel> findBooksByPublisherId(...)
//Esse é o método que será chamado no repositório. Ele retorna uma lista de objetos BookModel.

//BookModel provavelmente é uma entidade JPA que mapeia a tabela tb_book.
//O Spring vai usar os resultados da query SQL para montar objetos dessa classe.

//3. @Param("id") UUID id
//Essa anotação liga o parâmetro :id da query ao parâmetro do método UUID id.
//Quando alguém chama findBooksByPublisherId(someUuid), o Spring substitui :id na query pelo valor de someUuid.
//O tipo UUID é usado porque presumivelmente o campo publisher_id na tabela é do tipo UUID.




    
}