package com.example.demo.service;

import com.example.demo.dto.response.OrderItemResponseDto;

import java.util.List;

public interface OrderItemService {
    OrderItemResponseDto getById(Long id);
    List<OrderItemResponseDto> getAll();
}
