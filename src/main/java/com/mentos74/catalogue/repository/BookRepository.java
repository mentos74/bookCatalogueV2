package com.mentos74.catalogue.repository;

import com.mentos74.catalogue.domain.Book;




public interface BookRepository {
    public Book findBookById(Long id);

}
