package com.example.demo.service;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAll();
    UserResponseDto getById(Long id);
    UserResponseDto create(UserRequestDto dto);
    boolean delete(Long id);
}
