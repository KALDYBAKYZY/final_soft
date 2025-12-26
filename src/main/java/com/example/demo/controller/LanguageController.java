package com.example.demo.controller;

import com.example.demo.dto.request.LanguageRequestDto;
import com.example.demo.dto.response.LanguageResponseDto;
import com.example.demo.entity.Language;
import com.example.demo.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/languages")
public class LanguageController {

    private final LanguageService service;

    @GetMapping
    public ResponseEntity<List<LanguageResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageResponseDto> getById(@PathVariable Long id) {
        LanguageResponseDto dto = service.getById(id);
        return dto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<LanguageResponseDto> create(@RequestBody LanguageRequestDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
}

