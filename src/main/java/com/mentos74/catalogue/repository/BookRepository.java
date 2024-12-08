package com.mentos74.catalogue.repository;

import com.mentos74.catalogue.domain.Book;

import java.util.List;


public interface BookRepository {
    public Book findBookById(Long id);
    public List<Book> findAll();

}
