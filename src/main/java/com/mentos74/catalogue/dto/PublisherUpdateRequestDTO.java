package com.mentos74.catalogue.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class PublisherUpdateRequestDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = -5670005737427318736L;

    private String companyName;
    private String publisherName;
    private String address;
}
