package com.example.demo.service;

import com.example.demo.dto.request.LanguageRequestDto;
import com.example.demo.dto.response.LanguageResponseDto;
import com.example.demo.entity.Language;

import java.util.List;

public interface LanguageService {
    List<LanguageResponseDto> getAll();
    LanguageResponseDto getById(Long id);
    LanguageResponseDto create(LanguageRequestDto dto);
    boolean delete(Long id);
}
