package com.example.demo.service;

import com.example.demo.dto.request.FormatRequestDto;
import com.example.demo.dto.response.FormatResponseDto;
import com.example.demo.entity.Format;
import com.example.demo.mapper.FormatMapper;
import com.example.demo.repository.FormatRepository;
import com.example.demo.service.impl.FormatServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FormatServiceTest {

    @Mock
    private FormatRepository repository;

    @Mock
    private FormatMapper mapper;

    @InjectMocks
    private FormatServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateFormat() {
        FormatRequestDto dto = new FormatRequestDto();
        dto.setName("Ebook");

        Format format = new Format();
        format.setName("Ebook");

        Format saved = new Format();
        saved.setId(1L);
        saved.setName("Ebook");

        FormatResponseDto response = new FormatResponseDto();
        response.setName("Ebook");

        when(mapper.toEntity(dto)).thenReturn(format);
        when(repository.save(format)).thenReturn(saved);
        when(mapper.toDto(saved)).thenReturn(response);

        FormatResponseDto result = service.create(dto);
        assertEquals("Ebook", result.getName());
        verify(repository).save(format);
    }
}
