package com.example.demo.mapper;

import com.example.demo.dto.request.AuthorRequestDto;
import com.example.demo.dto.response.AuthorResponseDto;
import com.example.demo.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorResponseDto toDto(Author author);
    @Mapping(target = "books", ignore = true)
    Author toEntity(AuthorRequestDto dto);
}
