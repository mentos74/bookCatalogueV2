package com.mentos74.catalogue.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class Author {

    private Long id;

    private String name;

    private Long birthDate;




}