package com.example.demo.mapper;

import com.example.demo.dto.request.TagRequestDto;
import com.example.demo.dto.response.TagResponseDto;
import com.example.demo.entity.Tag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {

    Tag toEntity(TagRequestDto dto);

    TagResponseDto toDto(Tag tag);
}