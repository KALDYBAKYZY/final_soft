package com.example.demo.mapper;
import com.example.demo.dto.request.SeriesRequestDto;
import com.example.demo.dto.response.SeriesResponseDto;
import com.example.demo.entity.Series;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeriesMapper {

    Series toEntity(SeriesRequestDto dto);

    SeriesResponseDto toDto(Series series);
}