package com.example.demo.service;

import com.example.demo.dto.request.TagRequestDto;
import com.example.demo.dto.response.TagResponseDto;

import java.util.List;

public interface TagService {
    List<TagResponseDto> getAll();
    TagResponseDto getById(Long id);
    TagResponseDto create(TagRequestDto dto);
    boolean delete(Long id);
}
