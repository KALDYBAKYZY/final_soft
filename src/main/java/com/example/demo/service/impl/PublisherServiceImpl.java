package com.example.demo.service.impl;

import com.example.demo.dto.request.PublisherRequestDto;
import com.example.demo.dto.response.PublisherResponseDto;
import com.example.demo.entity.Publisher;
import com.example.demo.mapper.PublisherMapper;
import com.example.demo.repository.PublisherRepository;
import com.example.demo.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository repository;
    private final PublisherMapper mapper;

    @Override
    public PublisherResponseDto create(PublisherRequestDto dto) {
        Publisher publisher = mapper.toEntity(dto);
        return mapper.toDto(repository.save(publisher));
    }

    @Override
    public PublisherResponseDto update(Long id, PublisherRequestDto dto) {
        Publisher publisher = repository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        publisher.setName(dto.getName());
        return mapper.toDto(repository.save(publisher));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public PublisherResponseDto getById(Long id) {
        Publisher publisher = repository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        return mapper.toDto(publisher);
    }

    @Override
    public List<PublisherResponseDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }
}