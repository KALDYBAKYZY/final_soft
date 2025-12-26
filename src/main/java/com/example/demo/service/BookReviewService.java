package com.example.demo.service;

import com.example.demo.dto.request.BookReviewRequestDto;
import com.example.demo.dto.response.BookReviewResponseDto;

import java.util.List;

public interface BookReviewService {
    List<BookReviewResponseDto> getAll();
    BookReviewResponseDto getById(Long id);
    BookReviewResponseDto create(BookReviewRequestDto dto);
    BookReviewResponseDto update(Long id, BookReviewRequestDto dto);
    boolean delete(Long id);
}

