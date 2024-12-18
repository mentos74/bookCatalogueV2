package com.mentos74.catalogue.web;


import com.mentos74.catalogue.dto.CategoryCreateUpdateRequestDTO;
import com.mentos74.catalogue.dto.CategoryListResponseDTO;
import com.mentos74.catalogue.dto.ResultPageResponseDTO;
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

    @GetMapping("/v1/category")
    public ResponseEntity<ResultPageResponseDTO<CategoryListResponseDTO>> findCategoryList(
            @RequestParam(name = "pages", required = true, defaultValue = "0") Integer pages,
            @RequestParam(name = "limit", required = true, defaultValue = "10") Integer limit,
            @RequestParam(name = "sortBy", required = true, defaultValue = "name") String sortBy,
            @RequestParam(name = "direction", required = true, defaultValue = "asc") String direction,
            @RequestParam(name = "categoryName", required = false) String categoryName) {

        return ResponseEntity.ok().body(categoryService.findCategoryList(pages, limit, sortBy, direction, categoryName));
    }

}
