package com.mentos74.catalogue.services.impl;

import com.mentos74.catalogue.domain.Category;
import com.mentos74.catalogue.domain.Publisher;
import com.mentos74.catalogue.dto.CategoryCreateUpdateRequestDTO;
import com.mentos74.catalogue.dto.CategoryListResponseDTO;
import com.mentos74.catalogue.dto.ResultPageResponseDTO;
import com.mentos74.catalogue.exception.BadRequestException;
import com.mentos74.catalogue.repository.CategoryRepository;
import com.mentos74.catalogue.services.CategoryService;
import com.mentos74.catalogue.util.PaginationUtil;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public ResultPageResponseDTO<CategoryListResponseDTO> findCategoryList(Integer pages, Integer limit, String sortBy, String direction, String categoryName) {
        categoryName = StringUtils.isBlank(categoryName) ? "%" : categoryName + "%";
        Sort sort = Sort.by(new Sort.Order(PaginationUtil.getSortBy(direction), sortBy));
        Pageable pageable = PageRequest.of(pages, limit, sort);
        System.out.println("1>>" + categoryName);
        System.out.println("2>>" + pageable);
        Page<Category> pageResult = categoryRepository.findByNameLikeIgnoreCase(categoryName, pageable);

        List<CategoryListResponseDTO> dtos = pageResult.stream().map((x) -> {
            CategoryListResponseDTO categoryListResponseDTO = new CategoryListResponseDTO();
            categoryListResponseDTO.setNameCategory(x.getName());
            categoryListResponseDTO.setDescription(x.getDescription());
            categoryListResponseDTO.setCode(x.getCode());
            return categoryListResponseDTO;
        }).collect(Collectors.toList());

        return PaginationUtil.createResultDTO(dtos, pageResult.getTotalElements(), pageResult.getTotalPages());
    }

    @Override
    public List<Category> findCategoryList(List<String> categoryIdList) {
        List<Category> categories = categoryRepository.findByCodeIn(categoryIdList);
        if(categories.isEmpty()){
            throw new BadRequestException("category must be exist");
        }
        return categories;
    }
}
