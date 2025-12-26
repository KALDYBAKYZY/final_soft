package com.example.demo.service;

import com.example.demo.dto.request.PublisherRequestDto;
import com.example.demo.dto.response.PublisherResponseDto;

import java.util.List;

public interface PublisherService {
    PublisherResponseDto create(PublisherRequestDto dto);
    PublisherResponseDto update(Long id, PublisherRequestDto dto);
    void delete(Long id);
    PublisherResponseDto getById(Long id);
    List<PublisherResponseDto> getAll();
}
