package com.mentos74.catalogue.repository.impl;

import com.mentos74.catalogue.domain.Book;
import com.mentos74.catalogue.repository.BookRepository;
import lombok.Data;

import java.util.Map;
@Data
public class BookRepositoryImpl implements BookRepository{

    private Map<Long, Book> bookMap;


    @Override
    public Book findBookById(Long id) {
        Book book = bookMap.get(id);
        return book;
    }

}