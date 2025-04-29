package com.bookstore.jpa.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.jpa.dtos.BookRecordDto;
import com.bookstore.jpa.models.BookModel;
import com.bookstore.jpa.models.ReviewModel;
import com.bookstore.jpa.repositories.AuthorRepository;
import com.bookstore.jpa.repositories.BookRepository;
import com.bookstore.jpa.repositories.PublisherRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;


    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }


    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }





//@Transactional: garante que todas as operações dentro do método sejam executadas dentro de uma transação. Se algo der errado, todas as alterações são desfeitas (rollback)
//BookModel saveBook: método que retorna o livro salvo
//BookRecordDto bookRecordDto: DTO que vem do cliente (ex: via API REST), com os dados do livro a ser salvo
    @Transactional
    public BookModel saveBook(BookRecordDto bookRecordDto) {
        BookModel book = new BookModel(); //Instancia um novo livro.
        book.setTitle(bookRecordDto.title()); //define o título com base no DTO/ o que o cliente coloca
        book.setPublisher(publisherRepository.findById(bookRecordDto.publisherid()).get()); //busca editora pelo ID que veio no DTO usando o PublisherRepository
        book.setAuthors(authorRepository.findAllById(bookRecordDto.authorIds()).stream().collect(Collectors.toSet())); //busca todos os autores pelos IDs fornecidos no DTO. E converte amlsista para um set/conjunto, pois em book model tem um set<authormodel>
        
        ReviewModel reviewModel = new ReviewModel(); // cria uma review com o comentario passado
        reviewModel.setComment(bookRecordDto.reviewComment()); 
        reviewModel.setBook(book); //associa a review ao seu livro de acordo
        book.setReview(reviewModel); // e tbm o livro a review, garantindoo a ligaçao bidirecional(ligaçao vista quando estava fazendo a relaçao entre entidades)

        return bookRepository.save(book); // persiste o livro e retorna o livro salvo, com id gerado e etc(transaçao unica)
    }
    

    @Transactional
    public void deleteBook(UUID id){ // UUID é o identificador unico do livro a ser removido
        bookRepository.deleteById(id);  //usa o book repository para deletar o registro com o ID fornecido
        // se nao houver o livro o spring nao lançara exceçao automaticamente, apenas ira ignorar a operaçao
    }


    
}
