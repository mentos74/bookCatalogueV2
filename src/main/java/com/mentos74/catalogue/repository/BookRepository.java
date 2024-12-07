package com.mentos74.catalogue.repository;

import com.mentos74.catalogue.domain.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository {

    public Book findBookById(Long id);
}
