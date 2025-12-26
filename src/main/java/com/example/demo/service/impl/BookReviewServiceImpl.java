package com.example.demo.service.impl;

import com.example.demo.dto.request.BookReviewRequestDto;
import com.example.demo.dto.response.BookReviewResponseDto;
import com.example.demo.entity.BookReview;
import com.example.demo.mapper.BookReviewMapper;
import com.example.demo.repository.BookReviewRepository;
import com.example.demo.service.BookReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookReviewServiceImpl implements BookReviewService {

    private final BookReviewRepository repository;
    private final BookReviewMapper mapper;

    @Override
    public List<BookReviewResponseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public BookReviewResponseDto getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    @Override
    public BookReviewResponseDto create(BookReviewRequestDto dto) {
        BookReview review = mapper.toEntity(dto);
        return mapper.toDto(repository.save(review));
    }

    @Override
    public BookReviewResponseDto update(Long id, BookReviewRequestDto dto) {
        BookReview review = repository.findById(id).orElse(null);
        if (review == null) return null;

        mapper.update(review, dto);
        return mapper.toDto(repository.save(review));
    }

    @Override
    public boolean delete(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}
