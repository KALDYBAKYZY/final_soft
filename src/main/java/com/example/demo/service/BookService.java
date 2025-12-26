package com.example.demo.service;

import com.example.demo.dto.request.BookRequestDto;
import com.example.demo.dto.response.BookResponseDto;

import java.util.List;

public interface BookService {
    BookResponseDto create(BookRequestDto dto);
    BookResponseDto getById(Long id);
    List<BookResponseDto> getAll();
    BookResponseDto update(Long id, BookRequestDto dto);
    void delete(Long id);
}
