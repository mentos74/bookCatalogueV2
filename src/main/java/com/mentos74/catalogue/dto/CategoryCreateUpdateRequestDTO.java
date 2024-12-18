package com.mentos74.catalogue.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class CategoryCreateUpdateRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -587578871269796163L;

    @NotBlank
    private String code;

    @NotBlank
    private String name;

    private String description;

}
