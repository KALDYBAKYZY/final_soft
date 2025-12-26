package com.example.demo.service;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository repository;

    private UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @InjectMocks
    private UserServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new UserServiceImpl(repository, mapper);
    }

    @Test
    void testCreateUser() {
        UserRequestDto dto = new UserRequestDto();
        dto.setFullName("John Doe");

        User saved = new User();
        saved.setId(1L);
        saved.setFullName("John Doe");

        when(repository.save(any(User.class))).thenReturn(saved);

        assertEquals("John Doe", service.create(dto).getFullName());
    }
}
