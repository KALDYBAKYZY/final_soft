package com.example.demo.service;

import com.example.demo.dto.request.SeriesRequestDto;
import com.example.demo.dto.response.SeriesResponseDto;

import java.util.List;

public interface SeriesService {
    List<SeriesResponseDto> getAll();
    SeriesResponseDto getById(Long id);
    SeriesResponseDto create(SeriesRequestDto dto);
    boolean delete(Long id);
}

