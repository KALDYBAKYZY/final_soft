package com.example.demo.service.impl;

import com.example.demo.dto.request.SeriesRequestDto;
import com.example.demo.dto.response.SeriesResponseDto;
import com.example.demo.mapper.SeriesMapper;
import com.example.demo.repository.SeriesRepository;
import com.example.demo.service.SeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeriesServiceImpl implements SeriesService {

    private final SeriesRepository repository;
    private final SeriesMapper mapper;

    @Override
    public List<SeriesResponseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public SeriesResponseDto getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    @Override
    public SeriesResponseDto create(SeriesRequestDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public boolean delete(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}
