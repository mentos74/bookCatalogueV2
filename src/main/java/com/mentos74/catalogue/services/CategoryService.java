package com.mentos74.catalogue.services;

import com.mentos74.catalogue.dto.CategoryCreateUpdateRequestDTO;

public interface CategoryService {

    public void createAndUpdateCategory(CategoryCreateUpdateRequestDTO dto);
}
