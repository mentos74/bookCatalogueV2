package com.mentos74.catalogue.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class BookUpdateRequestDTO {


    @NotBlank
    private String bookTitle;

    @JsonProperty("synopsis")
    private String description;


}
