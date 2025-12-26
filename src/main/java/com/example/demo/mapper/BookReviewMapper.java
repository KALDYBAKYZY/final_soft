package com.example.demo.mapper;

import com.example.demo.dto.request.BookReviewRequestDto;
import com.example.demo.dto.response.BookReviewResponseDto;
import com.example.demo.entity.BookReview;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookReviewMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "book", ignore = true)
    BookReview toEntity(BookReviewRequestDto dto);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "book.id", target = "bookId")
    BookReviewResponseDto toDto(BookReview review);

    void update(@MappingTarget BookReview review, BookReviewRequestDto dto);

}

