package com.example.demo.service;

import com.example.demo.dto.request.TagRequestDto;
import com.example.demo.entity.Tag;
import com.example.demo.mapper.TagMapper;
import com.example.demo.repository.TagRepository;
import com.example.demo.service.impl.TagServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TagServiceTest {

    @Mock
    private TagRepository repository;

    private TagMapper mapper = Mappers.getMapper(TagMapper.class);

    @InjectMocks
    private TagServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new TagServiceImpl(repository, mapper);
    }

    @Test
    void testCreateTag() {
        TagRequestDto dto = new TagRequestDto();
        dto.setName("Fantasy");

        Tag saved = new Tag();
        saved.setId(1L);
        saved.setName("Fantasy");

        when(repository.save(any(Tag.class))).thenReturn(saved);

        assertEquals("Fantasy", service.create(dto).getName());
    }
}
