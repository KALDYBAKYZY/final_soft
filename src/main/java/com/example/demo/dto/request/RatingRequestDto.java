package com.example.demo.dto.request;

import lombok.Data;

@Data
public class RatingRequestDto {
    private Long userId;
    private Long bookId;
    private Integer score;
}
