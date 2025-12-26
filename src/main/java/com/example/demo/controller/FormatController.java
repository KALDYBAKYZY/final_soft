package com.example.demo.controller;

import com.example.demo.dto.request.FormatRequestDto;
import com.example.demo.dto.response.FormatResponseDto;
import com.example.demo.service.FormatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/formats")
@RequiredArgsConstructor
public class FormatController {

    private final FormatService service;

    @GetMapping
    public List<FormatResponseDto> getAll() {
        return service.getAll();
    }

    @PostMapping
    public FormatResponseDto create(@RequestBody FormatRequestDto dto) {
        return service.create(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
