package com.example.demo.service.impl;

import com.example.demo.dto.request.RatingRequestDto;
import com.example.demo.dto.response.RatingResponseDto;
import com.example.demo.entity.Rating;
import com.example.demo.mapper.RatingMapper;
import com.example.demo.repository.RatingRepository;
import com.example.demo.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository repository;
    private final RatingMapper mapper;

    @Override
    public List<RatingResponseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public RatingResponseDto getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    @Override
    public RatingResponseDto create(RatingRequestDto dto) {
        Rating rating = mapper.toEntity(dto);
        return mapper.toDto(repository.save(rating));
    }

    @Override
    public RatingResponseDto update(Long id, RatingRequestDto dto) {
        Rating rating = repository.findById(id).orElse(null);
        if (rating == null) return null;

        mapper.update(rating, dto);
        return mapper.toDto(repository.save(rating));
    }

    @Override
    public boolean delete(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}
