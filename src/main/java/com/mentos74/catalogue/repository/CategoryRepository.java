package com.mentos74.catalogue.repository;

import com.mentos74.catalogue.domain.Category;
import com.mentos74.catalogue.domain.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository  extends JpaRepository<Category, String> {
    public Optional<Category> findByCode (String code);
    public Page<Publisher> findByNameLikeIgnoreCase(String categoryName, Pageable pageable);
}
