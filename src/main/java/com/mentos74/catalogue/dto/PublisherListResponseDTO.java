package com.mentos74.catalogue.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PublisherListResponseDTO implements Serializable {

    private static final long serialVersionUID = 3755903972080183445L;
    private String publisherName;
    private String publisherId;
    private String companyName;

}
