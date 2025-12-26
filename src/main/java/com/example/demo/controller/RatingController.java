package com.example.demo.controller;

import com.example.demo.dto.request.RatingRequestDto;
import com.example.demo.dto.response.RatingResponseDto;
import com.example.demo.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService service;

    @GetMapping
    public ResponseEntity<List<RatingResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatingResponseDto> getById(@PathVariable Long id) {
        RatingResponseDto dto = service.getById(id);
        return dto == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<RatingResponseDto> create(
            @RequestBody RatingRequestDto dto) {

        return new ResponseEntity<>(
                service.create(dto),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<RatingResponseDto> update(
            @PathVariable Long id,
            @RequestBody RatingRequestDto dto) {

        RatingResponseDto updated = service.update(id, dto);
        return updated == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
}
