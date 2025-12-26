package com.example.demo.service;

import com.example.demo.dto.request.AuthorRequestDto;
import com.example.demo.entity.Author;
import com.example.demo.mapper.AuthorMapper;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.impl.AuthorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthorServiceTest {

    @Mock
    private AuthorRepository repository;

    private AuthorMapper mapper = Mappers.getMapper(AuthorMapper.class);

    @InjectMocks
    private AuthorServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new AuthorServiceImpl(repository, mapper);
    }

    @Test
    void testCreateAuthor() {
        AuthorRequestDto dto = new AuthorRequestDto();
        dto.setName("J.K.Rowling");

        Author saved = new Author();
        saved.setId(1L);
        saved.setName("J.K.Rowling");

        when(repository.save(any(Author.class))).thenReturn(saved);

        assertEquals("J.K.Rowling", service.create(dto).getName());
        verify(repository, times(1)).save(any(Author.class));
    }
}
