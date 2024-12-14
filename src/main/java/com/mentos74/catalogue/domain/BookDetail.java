package com.mentos74.catalogue.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "book_detail")
public class BookDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "settings")
    private String settings;

    @Column(name = "thumbnail")
    private String thumbnail;

    @OneToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
}
