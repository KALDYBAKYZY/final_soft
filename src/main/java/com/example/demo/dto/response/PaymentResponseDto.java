package com.example.demo.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PaymentResponseDto {
    private Long id;
    private Double amount;
    private String status;
    private LocalDateTime paidAt;
}

