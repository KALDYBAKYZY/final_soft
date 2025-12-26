package com.example.demo.mapper;
import com.example.demo.dto.request.BookRequestDto;
import com.example.demo.dto.response.BookResponseDto;
import com.example.demo.entity.Book;
import com.example.demo.entity.Tag;
import org.mapstruct.*;

import java.util.List;
@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(source = "author.name", target = "authorName")
    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "publisher.name", target = "publisherName")
    @Mapping(source = "language.name", target = "languageName")
    @Mapping(source = "format.name", target = "formatName")
    @Mapping(source = "series.name", target = "seriesName")
    @Mapping(source = "tags", target = "tags")
    BookResponseDto toDto(Book book);

    @Mapping(target = "author", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "publisher", ignore = true)
    @Mapping(target = "language", ignore = true)
    @Mapping(target = "format", ignore = true)
    @Mapping(target = "series", ignore = true)
    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "ratings", ignore = true)
    Book toEntity(BookRequestDto dto);

    @Mapping(target = "author", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "publisher", ignore = true)
    @Mapping(target = "language", ignore = true)
    @Mapping(target = "format", ignore = true)
    @Mapping(target = "series", ignore = true)
    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "ratings", ignore = true)
    void update(@MappingTarget Book book, BookRequestDto dto);

    default List<String> map(List<Tag> tags) {
        if (tags == null) return null;
        return tags.stream()
                .map(Tag::getName)
                .toList();
    }
}
