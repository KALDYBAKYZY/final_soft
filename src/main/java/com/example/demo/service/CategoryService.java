package com.example.demo.service;

import com.example.demo.dto.request.CategoryRequestDto;
import com.example.demo.dto.response.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    CategoryResponseDto create(CategoryRequestDto dto);
    CategoryResponseDto update(Long id, CategoryRequestDto dto);
    void delete(Long id);
    CategoryResponseDto getById(Long id);
    List<CategoryResponseDto> getAll();
}
