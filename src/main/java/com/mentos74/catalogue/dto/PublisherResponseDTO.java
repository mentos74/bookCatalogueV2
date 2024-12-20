package com.mentos74.catalogue.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublisherResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 7971107596093889126L;


    private String publisherId;
    private String publisherName;

}
