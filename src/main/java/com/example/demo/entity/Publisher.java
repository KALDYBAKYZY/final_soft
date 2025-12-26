package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "publishers")
@Getter
@Setter
public class Publisher extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;
}
