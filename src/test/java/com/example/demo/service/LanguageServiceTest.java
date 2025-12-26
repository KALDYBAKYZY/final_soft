package com.example.demo.service;

import com.example.demo.dto.request.LanguageRequestDto;
import com.example.demo.entity.Language;
import com.example.demo.mapper.LanguageMapper;
import com.example.demo.repository.LanguageRepository;
import com.example.demo.service.impl.LanguageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LanguageServiceTest {

    @Mock
    private LanguageRepository repository;

    private LanguageMapper mapper = Mappers.getMapper(LanguageMapper.class);

    @InjectMocks
    private LanguageServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new LanguageServiceImpl(repository, mapper);
    }

    @Test
    void testCreateLanguage() {
        LanguageRequestDto dto = new LanguageRequestDto();
        dto.setName("English");

        Language saved = new Language();
        saved.setId(1L);
        saved.setName("English");

        when(repository.save(any(Language.class))).thenReturn(saved);

        assertEquals("English", service.create(dto).getName());
    }
}
