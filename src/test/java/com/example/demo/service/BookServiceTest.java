package com.example.demo.service;

import com.example.demo.dto.request.BookRequestDto;
import com.example.demo.dto.response.BookResponseDto;
import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.impl.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository repository;

    @Mock
    private BookMapper mapper;

    @InjectMocks
    private BookServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateBook() {
        // given
        BookRequestDto dto = new BookRequestDto();
        dto.setTitle("Test Book");

        Book book = new Book();
        book.setTitle("Test Book");

        Book saved = new Book();
        saved.setId(1L);
        saved.setTitle("Test Book");

        BookResponseDto responseDto = new BookResponseDto();
        responseDto.setId(1L);
        responseDto.setTitle("Test Book");

        when(mapper.toEntity(dto)).thenReturn(book);
        when(repository.save(book)).thenReturn(saved);
        when(mapper.toDto(saved)).thenReturn(responseDto);

        BookResponseDto result = service.create(dto);

        assertEquals("Test Book", result.getTitle());
        verify(repository).save(book);
    }

    @Test
    void testGetById() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Test Book");

        BookResponseDto responseDto = new BookResponseDto();
        responseDto.setId(1L);
        responseDto.setTitle("Test Book");

        when(repository.findById(1L)).thenReturn(Optional.of(book));
        when(mapper.toDto(book)).thenReturn(responseDto);
        BookResponseDto result = service.getById(1L);

        assertEquals("Test Book", result.getTitle());
    }
}
