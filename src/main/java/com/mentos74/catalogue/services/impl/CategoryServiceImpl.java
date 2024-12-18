package com.mentos74.catalogue.services.impl;

import com.mentos74.catalogue.domain.Category;
import com.mentos74.catalogue.dto.CategoryCreateUpdateRequestDTO;
import com.mentos74.catalogue.repository.CategoryRepository;
import com.mentos74.catalogue.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;

    @Override
    public void createAndUpdateCategory(CategoryCreateUpdateRequestDTO dto) {

        Category category = categoryRepository.findByCode(dto.getCode().toLowerCase()).orElse(new Category());

        if (category.getCode() == null) {
            category.setCode(dto.getCode().toLowerCase());
        }
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        categoryRepository.save(category);


    }
}
