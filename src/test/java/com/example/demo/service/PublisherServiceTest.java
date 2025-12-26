package com.example.demo.service;

import com.example.demo.dto.request.PublisherRequestDto;
import com.example.demo.entity.Publisher;
import com.example.demo.mapper.PublisherMapper;
import com.example.demo.repository.PublisherRepository;
import com.example.demo.service.impl.PublisherServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PublisherServiceTest {

    @Mock
    private PublisherRepository repository;

    private PublisherMapper mapper = Mappers.getMapper(PublisherMapper.class);

    @InjectMocks
    private PublisherServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new PublisherServiceImpl(repository, mapper);
    }

    @Test
    void testCreatePublisher() {
        PublisherRequestDto dto = new PublisherRequestDto();
        dto.setName("Rosman");

        Publisher saved = new Publisher();
        saved.setId(1L);
        saved.setName("Rosman");

        when(repository.save(any(Publisher.class))).thenReturn(saved);

        assertEquals("Rosman", service.create(dto).getName());
        verify(repository, times(1)).save(any(Publisher.class));
    }

    @Test
    void testGetById() {
        Publisher publisher = new Publisher();
        publisher.setId(1L);
        publisher.setName("Rosman");

        when(repository.findById(1L)).thenReturn(Optional.of(publisher));

        assertEquals("Rosman", service.getById(1L).getName());
    }
}
