package com.mentos74.catalogue.config;

import com.mentos74.catalogue.domain.Author;
import com.mentos74.catalogue.domain.Book;
import com.mentos74.catalogue.repository.BookRepository;
import com.mentos74.catalogue.repository.impl.BookRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {

//    @Bean
//    public Author author() {
//        return new Author(1L, "Pramoedya Ananta Toer", null, false);
//    }
//
//    @Bean
//    public Book book1(Author author) {
//        Book book = new Book();
//        book.setId(1L);
//        book.setTitle("Bumi Manusia");
//        book.setDescription("Bumi Manusia adalah salah satu Novel karya Pramoedya Ananta Toer");
////        book.setAuthor(author);
//        return book;
//    }
//
//    @Bean
//    public Book book2(Author author) {
//        Book book = new Book();
//        book.setId(2L);
//        book.setTitle("Arok Dedes");
//        book.setDescription("Arok Dedes adalah salah satu Novel karya Pramoedya Ananta Toer");
////        book.setAuthor(author);
//        return book;
//    }
//
//    @Bean
//    public BookRepository bookRepository(Book book1, Book book2) {
//        Map<Long, Book> bookMap = new HashMap<Long, Book>();
//        bookMap.put(1L, book1);
//        bookMap.put(2L, book2);
//
//        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
//        bookRepository.setBookMap(bookMap);
//
//        return bookRepository;
//    }


}
