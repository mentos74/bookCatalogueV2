package com.mentos74.catalogue.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ResultPageResponseDTO<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1101930578588222081L;

    private List<T> result;
    private Integer pages;
    private Long elements;

}
