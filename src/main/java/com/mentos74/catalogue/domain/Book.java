package com.mentos74.catalogue.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Table(name = "book", indexes = {
        @Index(name = "book_secure_id",columnList = "secure_id")
})
@Entity
public class Book extends AbstarctBaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -493967282312085855L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = true, columnDefinition = "text")
    private String description;

    @ManyToOne
    @JoinColumn(name ="publisher_id", nullable = false)
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "book_author", joinColumns = {
            @JoinColumn(name = "book_id",referencedColumnName = "id")
    },inverseJoinColumns = {
            @JoinColumn(name = "author_id", referencedColumnName = "id")

    })
    private List<Author> authors;

    @ManyToMany
    @JoinTable(name = "book_category", joinColumns = {
            @JoinColumn(name = "book_id",referencedColumnName = "id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "category_code", referencedColumnName = "code")


    })
    private List<Category> categories;

//    private Author author;





}

