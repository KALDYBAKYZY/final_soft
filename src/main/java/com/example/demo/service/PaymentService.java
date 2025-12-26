package com.example.demo.service;

import com.example.demo.dto.request.PaymentRequestDto;
import com.example.demo.dto.response.PaymentResponseDto;

public interface PaymentService {
    PaymentResponseDto pay(PaymentRequestDto dto);
    PaymentResponseDto getById(Long id);
}
