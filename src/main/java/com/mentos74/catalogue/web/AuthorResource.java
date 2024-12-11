package com.mentos74.catalogue.web;

import com.mentos74.catalogue.dto.AuthorCreateRequestDTO;
import com.mentos74.catalogue.dto.AuthorResponseDTO;
import com.mentos74.catalogue.services.AuthorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@AllArgsConstructor
@RestController
public class AuthorResource {

private final AuthorService authorService;

    @GetMapping("/author/{id}/detail")
    public ResponseEntity<AuthorResponseDTO> findAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok().body(authorService.findById(id));
    }

    @PostMapping("/author")
    public ResponseEntity<AuthorCreateRequestDTO> createNewAuthor (@RequestBody @Valid AuthorCreateRequestDTO dto){
        authorService.createNewAuthor(dto);
        return ResponseEntity.created(URI.create("/author")).build();
    }

}
