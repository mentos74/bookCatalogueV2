package com.mentos74.catalogue.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    private Long id;

    private String name;

    private Long birthDate;




}