package com.mentos74.catalogue.services;

import com.mentos74.catalogue.dto.CategoryCreateUpdateRequestDTO;

import com.mentos74.catalogue.dto.CategoryListResponseDTO;
import com.mentos74.catalogue.dto.ResultPageResponseDTO;

public interface CategoryService {

    public void createAndUpdateCategory(CategoryCreateUpdateRequestDTO dto);
    public ResultPageResponseDTO<CategoryListResponseDTO> findCategoryList(Integer pages, Integer limit, String sortBy,
                                                                            String direction, String categoryName);
}
