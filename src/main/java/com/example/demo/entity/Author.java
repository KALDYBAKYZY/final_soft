package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
