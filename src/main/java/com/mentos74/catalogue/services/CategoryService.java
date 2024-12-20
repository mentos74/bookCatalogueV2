package com.mentos74.catalogue.services;

import com.mentos74.catalogue.domain.Author;
import com.mentos74.catalogue.domain.Category;
import com.mentos74.catalogue.dto.CategoryCreateUpdateRequestDTO;

import com.mentos74.catalogue.dto.CategoryListResponseDTO;
import com.mentos74.catalogue.dto.ResultPageResponseDTO;

import java.util.List;

public interface CategoryService {

    public void createAndUpdateCategory(CategoryCreateUpdateRequestDTO dto);
    public ResultPageResponseDTO<CategoryListResponseDTO> findCategoryList(Integer pages, Integer limit, String sortBy,
                                                                            String direction, String categoryName);
    public List<Category> findCategoryList(List <String> categoryIdList);
    public List<CategoryListResponseDTO> constructDTO(List<Category> categories);

    }
