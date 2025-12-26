package com.example.demo.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BookRequestDto {

    private String title;
    private String description;
    private Double price;

    private Long authorId;
    private Long categoryId;
    private Long publisherId;
    private Long languageId;
    private Long formatId;
    private Long seriesId;

    private List<Long> tagIds;
}