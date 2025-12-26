package com.example.demo.mapper;

import com.example.demo.dto.response.OrderItemResponseDto;
import com.example.demo.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    @Mapping(source = "book.title", target = "bookTitle")
    OrderItemResponseDto toDto(OrderItem orderItem);
}
