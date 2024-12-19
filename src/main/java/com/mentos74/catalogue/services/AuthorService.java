package com.mentos74.catalogue.services;

import com.mentos74.catalogue.domain.Author;
import com.mentos74.catalogue.dto.AuthorCreateRequestDTO;
import com.mentos74.catalogue.dto.AuthorResponseDTO;
import com.mentos74.catalogue.dto.AuthorUpdateRequestDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AuthorService {
    public AuthorResponseDTO findById(String id);
    public List<Author> findByNameLike(String name);
    public void createNewAuthor(List <AuthorCreateRequestDTO> dto);
    public void updateAuthor(String id, AuthorUpdateRequestDTO dto);
    public void deleteAuthor(String id);
}
