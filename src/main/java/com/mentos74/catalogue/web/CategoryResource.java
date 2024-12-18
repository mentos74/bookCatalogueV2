package com.mentos74.catalogue.web;


import com.mentos74.catalogue.dto.CategoryCreateUpdateRequestDTO;
import com.mentos74.catalogue.services.impl.CategoryServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@AllArgsConstructor
@RestController
public class CategoryResource {

    private final CategoryServiceImpl categoryService;


    @PostMapping("/v1/category")
    public ResponseEntity<Void> createCategory(@RequestBody @Valid CategoryCreateUpdateRequestDTO dto) {
        categoryService.createAndUpdateCategory(dto);
        return ResponseEntity.created(URI.create("/v1/category")).build();
    }

//    @PutMapping("/v1/category/{codeCategory}")
//    public ResponseEntity<Void> updateCategory(@RequestBody @Valid CategoryCreateUpdateRequestDTO dto, @PathVariable String codeCategory) {
//        dto.setCode(codeCategory);
//        categoryService.createAndUpdateCategory(dto);
//        return ResponseEntity.created(URI.create("/v1/category")).build();
//    }

}
