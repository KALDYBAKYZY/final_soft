package com.example.demo.service;

import com.example.demo.dto.request.RatingRequestDto;
import com.example.demo.dto.response.RatingResponseDto;

import java.util.List;

public interface RatingService {
    List<RatingResponseDto> getAll();

    RatingResponseDto getById(Long id);

    RatingResponseDto create(RatingRequestDto dto);

    RatingResponseDto update(Long id, RatingRequestDto dto);

    boolean delete(Long id);
}
