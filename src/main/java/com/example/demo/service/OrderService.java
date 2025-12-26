package com.example.demo.service;

import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.dto.response.OrderResponseDto;

import java.util.List;

public interface OrderService {
    OrderResponseDto create(OrderRequestDto dto);
    OrderResponseDto getById(Long id);
    List<OrderResponseDto> getAll();
}
