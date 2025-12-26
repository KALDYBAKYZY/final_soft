package com.example.demo.mapper;

import com.example.demo.dto.response.PaymentResponseDto;
import com.example.demo.entity.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentResponseDto toDto(Payment payment);
}