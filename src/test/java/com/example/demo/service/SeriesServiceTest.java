package com.example.demo.service;

import com.example.demo.dto.request.SeriesRequestDto;
import com.example.demo.entity.Series;
import com.example.demo.mapper.SeriesMapper;
import com.example.demo.repository.SeriesRepository;
import com.example.demo.service.impl.SeriesServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SeriesServiceTest {

    @Mock
    private SeriesRepository repository;

    private SeriesMapper mapper = Mappers.getMapper(SeriesMapper.class);

    @InjectMocks
    private SeriesServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new SeriesServiceImpl(repository, mapper);
    }

    @Test
    void testCreateSeries() {
        SeriesRequestDto dto = new SeriesRequestDto();
        dto.setName("Harry Potter");

        Series saved = new Series();
        saved.setId(1L);
        saved.setName("Harry Potter");

        when(repository.save(any(Series.class))).thenReturn(saved);

        assertEquals("Harry Potter", service.create(dto).getName());
    }
}
