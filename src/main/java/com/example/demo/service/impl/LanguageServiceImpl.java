package com.example.demo.service.impl;

import com.example.demo.dto.request.LanguageRequestDto;
import com.example.demo.dto.response.LanguageResponseDto;
import com.example.demo.mapper.LanguageMapper;
import com.example.demo.repository.LanguageRepository;
import com.example.demo.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository repository;
    private final LanguageMapper mapper;

    @Override
    public List<LanguageResponseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public LanguageResponseDto getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    @Override
    public LanguageResponseDto create(LanguageRequestDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public boolean delete(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}
