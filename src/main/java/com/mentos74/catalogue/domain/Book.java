package com.mentos74.catalogue.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Data
@Table(name = "book")
@Entity
public class Book implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -493967282312085855L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = true)
    private String description;

//    private Author author;





}

