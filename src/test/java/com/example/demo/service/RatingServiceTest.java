package com.example.demo.service;

import com.example.demo.dto.request.RatingRequestDto;
import com.example.demo.entity.Rating;
import com.example.demo.mapper.RatingMapper;
import com.example.demo.repository.RatingRepository;
import com.example.demo.service.impl.RatingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RatingServiceTest {

    @Mock
    private RatingRepository repository;

    private RatingMapper mapper = Mappers.getMapper(RatingMapper.class);

    @InjectMocks
    private RatingServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new RatingServiceImpl(repository, mapper);
    }

    @Test
    void testCreateRating() {
        RatingRequestDto dto = new RatingRequestDto();
        dto.setScore(5);

        Rating saved = new Rating();
        saved.setId(1L);
        saved.setScore(5);

        when(repository.save(any(Rating.class))).thenReturn(saved);

        assertEquals(5, service.create(dto).getScore());
    }
}
