package com.example.demo.dto.response;

import lombok.Data;

@Data
public class BookReviewResponseDto {
    private Long id;
    private String reviewText;
    private Long userId;
    private Long bookId;
    private Integer rating;
}