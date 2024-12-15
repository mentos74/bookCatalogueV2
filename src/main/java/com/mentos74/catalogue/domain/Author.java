package com.mentos74.catalogue.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "author")
@SQLDelete(sql="UPDATE author set deleted = true where id = ?")
@Where(clause =  "deleted=false")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
    @SequenceGenerator(name = "author_generator",sequenceName = "author_id_seq")
    private Long id;

    @Column(name = "author_name", nullable = false, columnDefinition = "varchar(300)")
    private String name;


    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name="deleted", columnDefinition = "boolean default false")
    private Boolean deleted;




}