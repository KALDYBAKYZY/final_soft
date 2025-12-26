package com.example.demo.mapper;

import com.example.demo.dto.request.LanguageRequestDto;
import com.example.demo.dto.response.LanguageResponseDto;
import com.example.demo.entity.Language;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LanguageMapper {

    Language toEntity(LanguageRequestDto dto);

    LanguageResponseDto toDto(Language language);
}
