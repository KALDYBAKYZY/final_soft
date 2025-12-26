package com.example.demo.controller;

import com.example.demo.dto.request.BookReviewRequestDto;
import com.example.demo.dto.response.BookReviewResponseDto;
import com.example.demo.service.BookReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class BookReviewController {

    private final BookReviewService service;

    @GetMapping
    public ResponseEntity<List<BookReviewResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookReviewResponseDto> getById(@PathVariable Long id) {
        BookReviewResponseDto dto = service.getById(id);
        return dto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<BookReviewResponseDto> create(@RequestBody BookReviewRequestDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookReviewResponseDto> update(
            @PathVariable Long id,
            @RequestBody BookReviewRequestDto dto) {

        BookReviewResponseDto updated = service.update(id, dto);
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
}

