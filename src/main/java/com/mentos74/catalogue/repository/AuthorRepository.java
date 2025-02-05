package com.mentos74.catalogue.repository;

import com.mentos74.catalogue.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    public Optional<Author> findById(Long id);

    public Optional<Author> findBySecureId(String id);

    public List<Author> findBySecureIdIn(List<String> authorIdList);

    public Optional<Author> findByIdAndDeletedFalse(Long id);

}
