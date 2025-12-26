package com.example.demo.service.impl;

import com.example.demo.dto.request.TagRequestDto;
import com.example.demo.dto.response.TagResponseDto;
import com.example.demo.mapper.TagMapper;
import com.example.demo.repository.TagRepository;
import com.example.demo.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository repository;
    private final TagMapper mapper;

    @Override
    public List<TagResponseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public TagResponseDto getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    @Override
    public TagResponseDto create(TagRequestDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public boolean delete(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}
