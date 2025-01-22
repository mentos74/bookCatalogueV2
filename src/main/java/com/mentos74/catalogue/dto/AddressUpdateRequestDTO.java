package com.mentos74.catalogue.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddressUpdateRequestDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = 3139392663031226499L;

    private Long addressId;
    private String streetName;
    private String cityName;
    private String zipCode;
}
