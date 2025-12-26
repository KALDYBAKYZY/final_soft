package com.example.demo.dto.request;

import lombok.Data;

@Data
public class BookReviewRequestDto {
    private Long userId;
    private Long bookId;
    private String reviewText;
    private Integer rating;
}