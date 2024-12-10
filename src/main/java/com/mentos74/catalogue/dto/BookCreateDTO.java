package com.mentos74.catalogue.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class BookCreateDTO {

    @NotBlank
    private String bookTitle;

    @NotBlank
    private String authorName;

    @JsonProperty("synopsis")
    private String description;
}
