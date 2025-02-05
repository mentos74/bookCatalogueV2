package com.mentos74.catalogue.repository;

import com.mentos74.catalogue.domain.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    public Optional<Publisher> findIdBySecureId(String secureId);

    public Page<Publisher> findByNameLikeIgnoreCase(String publisherName, Pageable pageable);
}
