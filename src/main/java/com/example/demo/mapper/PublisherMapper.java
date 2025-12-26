package com.example.demo.mapper;

import com.example.demo.dto.request.PublisherRequestDto;
import com.example.demo.dto.response.PublisherResponseDto;
import com.example.demo.entity.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PublisherMapper {
    PublisherResponseDto toDto(Publisher publisher);

    @Mapping(target = "books", ignore = true)
    Publisher toEntity(PublisherRequestDto dto);
}
