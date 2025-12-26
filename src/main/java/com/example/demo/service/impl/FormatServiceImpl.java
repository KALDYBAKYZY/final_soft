package com.example.demo.service.impl;

import com.example.demo.dto.request.FormatRequestDto;
import com.example.demo.dto.response.FormatResponseDto;
import com.example.demo.entity.Format;
import com.example.demo.mapper.FormatMapper;
import com.example.demo.repository.FormatRepository;
import com.example.demo.service.FormatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormatServiceImpl implements FormatService {

    private final FormatRepository repository;
    private final FormatMapper mapper;

    @Override
    public List<FormatResponseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public FormatResponseDto getById(Long id) {
        Format format = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Format not found"));
        return mapper.toDto(format);
    }

    @Override
    public FormatResponseDto create(FormatRequestDto dto) {
        Format format = mapper.toEntity(dto);
        Format saved = repository.save(format);
        return mapper.toDto(saved);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
