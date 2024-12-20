package com.mentos74.catalogue.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class PublisherCreateRequestDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = 403967671803881049L;

    @NotBlank
    private String companyName;

    @NotBlank
    private String publisherName;

    private String address;
}
