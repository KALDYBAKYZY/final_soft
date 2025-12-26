package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book_reviews")
@Getter
@Setter
public class BookReview extends BaseEntity {

    @Column(name = "review_text", columnDefinition = "TEXT")
    private String reviewText;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "rating")
    private Integer rating; // можно отдельно использовать сущность Rating
}
