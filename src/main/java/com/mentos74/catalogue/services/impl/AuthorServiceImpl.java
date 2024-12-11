package com.mentos74.catalogue.services.impl;

import com.mentos74.catalogue.domain.Author;
import com.mentos74.catalogue.dto.AuthorResponseDTO;
import com.mentos74.catalogue.exception.BadRequestException;
import com.mentos74.catalogue.repository.AuthorRepository;
import com.mentos74.catalogue.services.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorResponseDTO findById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(()-> new BadRequestException("invalid.authorId"));

        AuthorResponseDTO responseDTO = new AuthorResponseDTO();
        responseDTO.setAuthorName(author.getName());
        responseDTO.setBirthDate(author.getBirthDate().toEpochDay());
        return responseDTO;
    }

    @Override
    public List<Author> findByNameLike(String name) {
        return List.of();
    }
}
