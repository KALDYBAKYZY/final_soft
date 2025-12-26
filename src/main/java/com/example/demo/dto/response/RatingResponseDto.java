package com.example.demo.dto.response;


import lombok.Data;

@Data
public class RatingResponseDto {
    private Long id;
    private Integer score;
    private Long userId;
    private Long bookId;
}