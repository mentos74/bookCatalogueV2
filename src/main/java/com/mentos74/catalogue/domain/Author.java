package com.mentos74.catalogue.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @Column(name="name", nullable = false, columnDefinition = "varchar(300)")
    private String name;


    @Column(name="birth_date", nullable = false)
    private LocalDate birthDate;




}