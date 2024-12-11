package com.mentos74.catalogue.web;

import com.mentos74.catalogue.dto.AuthorResponseDTO;
import com.mentos74.catalogue.services.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class AuthorResource {

private final AuthorService authorService;

@GetMapping("/author/{id}/detail")
    public ResponseEntity<AuthorResponseDTO> findAuthorById(@PathVariable Long id) {
//        AuthorResponseDTO dto = new AuthorResponseDTO();
//        dto.setBirthDate(55555L);
//        dto.setAuthorName("jemboat");
        return ResponseEntity.ok().body(authorService.findById(id));
    }
}
