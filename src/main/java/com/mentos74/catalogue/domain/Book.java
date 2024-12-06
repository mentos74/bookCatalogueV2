package com.mentos74.catalogue.domain;

import lombok.Data;

@Data
public class Book {
private Long id;
private String title;
private String description;
private Author author;

}
