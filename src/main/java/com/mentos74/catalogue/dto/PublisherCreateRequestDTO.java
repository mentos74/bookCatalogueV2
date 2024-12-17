package com.mentos74.catalogue.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class PublisherCreateRequestDTO implements Serializable {



    private static final long serialVersionUID = 403967671803881049L;

    @NotBlank
    private String companyName;

    @NotBlank
    private String publisherName;

    private String address;
}
