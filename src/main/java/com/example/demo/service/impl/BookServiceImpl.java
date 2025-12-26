package com.example.demo.service.impl;

import com.example.demo.dto.request.BookRequestDto;
import com.example.demo.dto.response.BookResponseDto;
import com.example.demo.mapper.BookMapper;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final PublisherRepository publisherRepository;
    private final LanguageRepository languageRepository;
    private final FormatRepository formatRepository;
    private final SeriesRepository seriesRepository;
    private final TagRepository tagRepository;
    private final BookMapper bookMapper;

    @Override
    public BookResponseDto create(BookRequestDto dto) {
        Book book = bookMapper.toEntity(dto);

        book.setAuthor(authorRepository.findById(dto.getAuthorId()).orElse(null));
        book.setCategory(categoryRepository.findById(dto.getCategoryId()).orElse(null));
        book.setPublisher(publisherRepository.findById(dto.getPublisherId()).orElse(null));
        book.setLanguage(languageRepository.findById(dto.getLanguageId()).orElse(null));
        book.setFormat(formatRepository.findById(dto.getFormatId()).orElse(null));
        book.setSeries(seriesRepository.findById(dto.getSeriesId()).orElse(null));
        book.setTags(tagRepository.findAllById(dto.getTagIds()));

        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public BookResponseDto getById(Long id) {
        return bookMapper.toDto(
                bookRepository.findById(id).orElseThrow()
        );
    }

    @Override
    public List<BookResponseDto> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookResponseDto update(Long id, BookRequestDto dto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        // простые поля
        bookMapper.update(book, dto);

        // связи
        if (dto.getAuthorId() != null) {
            book.setAuthor(
                    authorRepository.findById(dto.getAuthorId()).orElse(null)
            );
        }

        if (dto.getCategoryId() != null) {
            book.setCategory(
                    categoryRepository.findById(dto.getCategoryId()).orElse(null)
            );
        }

        if (dto.getPublisherId() != null) {
            book.setPublisher(
                    publisherRepository.findById(dto.getPublisherId()).orElse(null)
            );
        }

        if (dto.getLanguageId() != null) {
            book.setLanguage(
                    languageRepository.findById(dto.getLanguageId()).orElse(null)
            );
        }

        if (dto.getFormatId() != null) {
            book.setFormat(
                    formatRepository.findById(dto.getFormatId()).orElse(null)
            );
        }

        if (dto.getSeriesId() != null) {
            book.setSeries(
                    seriesRepository.findById(dto.getSeriesId()).orElse(null)
            );
        }

        if (dto.getTagIds() != null) {
            book.setTags(tagRepository.findAllById(dto.getTagIds()));
        }

        return bookMapper.toDto(bookRepository.save(book));
    }


    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
