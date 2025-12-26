package com.example.demo.controller;

import com.example.demo.dto.response.OrderItemResponseDto;
import com.example.demo.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-items")
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemService service;

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<OrderItemResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
