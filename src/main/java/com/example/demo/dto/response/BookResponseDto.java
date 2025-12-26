package com.example.demo.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class BookResponseDto {

    private Long id;
    private String title;
    private String description;
    private Double price;

    private String authorName;
    private String categoryName;
    private String publisherName;
    private String languageName;
    private String formatName;
    private String seriesName;

    private List<String> tags;
}
