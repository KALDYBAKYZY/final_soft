package com.example.demo.service;

import com.example.demo.dto.request.AuthorRequestDto;
import com.example.demo.dto.response.AuthorResponseDto;

import java.util.List;

public interface AuthorService {
    AuthorResponseDto create(AuthorRequestDto dto);
    AuthorResponseDto update(Long id, AuthorRequestDto dto);
    void delete(Long id);
    AuthorResponseDto getById(Long id);
    List<AuthorResponseDto> getAll();
}
