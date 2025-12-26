package com.example.demo.service.impl;

import com.example.demo.dto.request.AuthorRequestDto;
import com.example.demo.dto.response.AuthorResponseDto;
import com.example.demo.entity.Author;
import com.example.demo.mapper.AuthorMapper;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;
    private final AuthorMapper mapper;

    @Override
    public AuthorResponseDto create(AuthorRequestDto dto) {
        Author author = mapper.toEntity(dto);
        return mapper.toDto(repository.save(author));
    }

    @Override
    public AuthorResponseDto update(Long id, AuthorRequestDto dto) {
        Author author = repository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        author.setName(dto.getName());
        return mapper.toDto(repository.save(author));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public AuthorResponseDto getById(Long id) {
        Author author = repository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        return mapper.toDto(author);
    }

    @Override
    public List<AuthorResponseDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }
}
