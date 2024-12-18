package com.mentos74.catalogue.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CategoryListResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4442793044164656248L;
    private String code;
    private String nameCategory;
    private String description;
}
