package com.example.demo.service;

import com.example.demo.dto.request.CategoryRequestDto;
import com.example.demo.entity.Category;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryServiceTest {

    @Mock
    private CategoryRepository repository;

    private CategoryMapper mapper = Mappers.getMapper(CategoryMapper.class);

    @InjectMocks
    private CategoryServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new CategoryServiceImpl(repository, mapper);
    }

    @Test
    void testCreateCategory() {
        CategoryRequestDto dto = new CategoryRequestDto();
        dto.setName("Fantasy");

        Category saved = new Category();
        saved.setId(1L);
        saved.setName("Fantasy");

        when(repository.save(any(Category.class))).thenReturn(saved);

        assertEquals("Fantasy", service.create(dto).getName());
        verify(repository, times(1)).save(any(Category.class));
    }

    @Test
    void testGetById() {
        Category category = new Category();
        category.setId(1L);
        category.setName("Fantasy");

        when(repository.findById(1L)).thenReturn(Optional.of(category));

        assertEquals("Fantasy", service.getById(1L).getName());
    }
}
