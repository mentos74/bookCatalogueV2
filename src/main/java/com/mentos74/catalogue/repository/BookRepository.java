package com.mentos74.catalogue.repository;

import com.mentos74.catalogue.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, Long> {
    public Optional<Book> findById(Long id);
    public Optional<Book> findBySecureId(String secureId);
//    public List<Book> findAll();
//    public void save(Book book);
//    public void update(Book book);
//    public void delete(Long id);

}
