package com.mentos74.catalogue.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookCreateDTO {

    @NotBlank
    private String bookTitle;

    @NotBlank
    private String authorName;
    
    private String description;
}
