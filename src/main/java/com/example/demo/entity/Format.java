package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "formats")
@Getter
@Setter
public class Format extends BaseEntity {

    @Column(name = "name")
    private String name;
}
