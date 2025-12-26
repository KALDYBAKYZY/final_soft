package com.example.demo.service;

import com.example.demo.dto.request.BookReviewRequestDto;
import com.example.demo.entity.BookReview;
import com.example.demo.mapper.BookReviewMapper;
import com.example.demo.repository.BookReviewRepository;
import com.example.demo.service.impl.BookReviewServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookReviewServiceTest {

    @Mock
    private BookReviewRepository repository;

    private BookReviewMapper mapper = Mappers.getMapper(BookReviewMapper.class);

    @InjectMocks
    private BookReviewServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new BookReviewServiceImpl(repository, mapper);
    }

    @Test
    void testCreateReview() {
        BookReviewRequestDto dto = new BookReviewRequestDto();
        dto.setReviewText("Nice book");

        BookReview saved = new BookReview();
        saved.setId(1L);
        saved.setReviewText("Nice book");

        when(repository.save(any(BookReview.class))).thenReturn(saved);

        assertEquals("Nice book", service.create(dto).getReviewText());
    }
}
