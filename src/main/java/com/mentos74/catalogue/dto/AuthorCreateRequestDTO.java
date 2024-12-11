package com.mentos74.catalogue.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AuthorCreateRequestDTO {

    @NotNull
    private String authorName;
    @NotNull
    private Long birthDate;
}
