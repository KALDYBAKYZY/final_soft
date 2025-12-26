package com.example.demo.service.impl;

import com.example.demo.dto.response.OrderItemResponseDto;
import com.example.demo.entity.OrderItem;
import com.example.demo.mapper.OrderItemMapper;
import com.example.demo.repository.OrderItemRepository;
import com.example.demo.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository repository;
    private final OrderItemMapper mapper;

    @Override
    public OrderItemResponseDto getById(Long id) {
        OrderItem item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found"));
        return mapper.toDto(item);
    }

    @Override
    public List<OrderItemResponseDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
