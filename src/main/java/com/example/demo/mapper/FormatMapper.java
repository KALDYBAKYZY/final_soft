package com.example.demo.mapper;
import com.example.demo.dto.request.FormatRequestDto;
import com.example.demo.dto.response.FormatResponseDto;
import com.example.demo.entity.Format;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FormatMapper {

    Format toEntity(FormatRequestDto dto);

    FormatResponseDto toDto(Format format);
}