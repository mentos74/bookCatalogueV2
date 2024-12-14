package com.mentos74.catalogue.repository.impl;

import com.mentos74.catalogue.domain.Book;
import com.mentos74.catalogue.repository.BookRepository;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Data
public class BookRepositoryImpl {


    private Map<Long, Book> bookMap;

//
//    @Override
//    public Book findBookById(Long id) {
//        Book book = bookMap.get(id);
//        return book;
//    }
//
//    @Override
//    public List<Book> findAll() {
//        List <Book> bookList = new ArrayList<>(bookMap.values());
//        return bookList;
//    }
//
//    @Override
//    public void save(Book book) {
//        int size = bookMap.size();
//        book.setId(Long.valueOf(size+1));
//        bookMap.put(book.getId(),book);
//    }
//
//    @Override
//    public void update(Book book) {
//
//
//        bookMap.put(book.getId(),book);
//
//    }
//
//    @Override
//    public void delete(Long id) {
//
//        bookMap.remove(id);
//    }

}