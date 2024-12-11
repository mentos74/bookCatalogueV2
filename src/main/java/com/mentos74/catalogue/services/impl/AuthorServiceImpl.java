package com.mentos74.catalogue.services.impl;

import com.mentos74.catalogue.domain.Author;
import com.mentos74.catalogue.dto.AuthorCreateRequestDTO;
import com.mentos74.catalogue.dto.AuthorResponseDTO;
import com.mentos74.catalogue.dto.AuthorUpdateRequestDTO;
import com.mentos74.catalogue.exception.BadRequestException;
import com.mentos74.catalogue.repository.AuthorRepository;
import com.mentos74.catalogue.services.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorResponseDTO findById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("invalid.authorId"));

        AuthorResponseDTO responseDTO = new AuthorResponseDTO();
        responseDTO.setAuthorName(author.getName());
        responseDTO.setBirthDate(author.getBirthDate().toEpochDay());
        return responseDTO;
    }

    @Override
    public List<Author> findByNameLike(String name) {
        return List.of();
    }

    @Override
    public void createNewAuthor(List<AuthorCreateRequestDTO> listDto) {
        List<Author> listAuthor = new ArrayList<>();
        for (AuthorCreateRequestDTO dto : listDto) {
            Author author = new Author();
            author.setName(dto.getAuthorName());
            author.setBirthDate(LocalDate.ofEpochDay(dto.getBirthDate()));
            listAuthor.add(author);
        }

        authorRepository.saveAll(listAuthor);

    }

    @Override
    public void updateAuthor(Long id, AuthorUpdateRequestDTO dto) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new BadRequestException("invalidId"));
        author.setBirthDate(dto.getBirthDate() == null ? author.getBirthDate() : LocalDate.ofEpochDay(dto.getBirthDate()));
        author.setName(dto.getAuthorName() == null ? author.getName() : dto.getAuthorName());
        authorRepository.save(author);
    }


}
