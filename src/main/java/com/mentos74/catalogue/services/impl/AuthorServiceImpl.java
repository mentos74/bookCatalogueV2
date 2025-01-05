package com.mentos74.catalogue.services.impl;

import com.mentos74.catalogue.domain.Address;
import com.mentos74.catalogue.domain.Author;
import com.mentos74.catalogue.dto.AuthorCreateRequestDTO;
import com.mentos74.catalogue.dto.AuthorResponseDTO;
import com.mentos74.catalogue.dto.AuthorUpdateRequestDTO;
import com.mentos74.catalogue.exception.ResourceNotFoundException;
import com.mentos74.catalogue.repository.AuthorRepository;
import com.mentos74.catalogue.services.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorResponseDTO findById(String id) {
        Author author = authorRepository.findBySecureId(id)
                .orElseThrow(() -> new ResourceNotFoundException("invalid.authorId"));

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
            author.setDeleted(false);

            List <Address> addresses =  dto.getAddresses().stream().map((a) -> {
                Address address = new Address();
                address.setAuthor(author);
                address.setCityName(a.getCityName());
                address.setZipCode(a.getZipCode());
                address.setStreetName(a.getStreetName());
                return address;
            }).collect(Collectors.toList());
            author.setAddresses(addresses);

            listAuthor.add(author);
        }

        authorRepository.saveAll(listAuthor);

    }

    @Override
    public void updateAuthor(String id, AuthorUpdateRequestDTO dto) {
        Author author = authorRepository.findBySecureId(id).orElseThrow(() -> new ResourceNotFoundException("invalidId"));
        author.setBirthDate(dto.getBirthDate() == null ? author.getBirthDate() : LocalDate.ofEpochDay(dto.getBirthDate()));
        author.setName(dto.getAuthorName() == null ? author.getName() : dto.getAuthorName());
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(String id) {
        Author author = authorRepository.findBySecureId(id).orElseThrow(() -> new ResourceNotFoundException("invalidId"));
        authorRepository.save(author);
    }

    @Override
    public List<Author> findAuthorList(List<String> authorsIdList) {
        List<Author> listAuthors = authorRepository.findBySecureIdIn(authorsIdList);
        if (listAuthors.isEmpty()) {
            throw new ResourceNotFoundException("author cant be empty");
        }
        return listAuthors;
    }

    @Override
    public List<AuthorResponseDTO> constructDTO(List<Author> authors) {
        return authors.stream().map((c) -> {
            AuthorResponseDTO dto = new AuthorResponseDTO();
            dto.setAuthorName(c.getName());
            dto.setBirthDate(c.getBirthDate().toEpochDay());
            return dto;
        }).collect(Collectors.toList());
    }


}
