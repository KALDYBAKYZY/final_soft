package com.example.demo.mapper;

import com.example.demo.dto.request.BookReviewRequestDto;
import com.example.demo.dto.request.RatingRequestDto;
import com.example.demo.dto.response.RatingResponseDto;
import com.example.demo.entity.BookReview;
import com.example.demo.entity.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RatingMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "book", ignore = true)
    Rating toEntity(RatingRequestDto dto);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "book.id", target = "bookId")
    RatingResponseDto toDto(Rating rating);

    void update(@MappingTarget Rating rating, RatingRequestDto dto);
}
