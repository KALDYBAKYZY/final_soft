package com.example.demo.mapper;

import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = {OrderItemMapper.class, PaymentMapper.class})
public interface OrderMapper {
    OrderResponseDto toDto(Order order);
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "items", ignore = true)
    @Mapping(target = "payment", ignore = true)
    Order toEntity(OrderRequestDto dto);
}

