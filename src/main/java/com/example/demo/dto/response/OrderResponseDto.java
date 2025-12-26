package com.example.demo.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderResponseDto {
    private Long id;
    private String status;
    private LocalDateTime createdAt;
    private List<OrderItemResponseDto> items;
    private PaymentResponseDto payment;
}
