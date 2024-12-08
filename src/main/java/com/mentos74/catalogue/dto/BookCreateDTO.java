package com.mentos74.catalogue.dto;

import lombok.Data;

@Data
public class BookCreateDTO {
    private String bookTitle;
    private String authorName;
    private String description;
}