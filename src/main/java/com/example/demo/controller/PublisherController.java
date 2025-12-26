package com.example.demo.controller;

import com.example.demo.dto.request.PublisherRequestDto;
import com.example.demo.dto.response.PublisherResponseDto;
import com.example.demo.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherService service;

    @GetMapping
    public ResponseEntity<List<PublisherResponseDto>> getAll() {
        var list = service.getAll();

        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<PublisherResponseDto> add(
            @RequestBody PublisherRequestDto dto) {

        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublisherResponseDto> update(
            @PathVariable Long id,
            @RequestBody PublisherRequestDto dto) {

        var updated = service.update(id, dto);

        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
