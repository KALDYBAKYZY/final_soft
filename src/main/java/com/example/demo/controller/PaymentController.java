package com.example.demo.controller;

import com.example.demo.dto.request.PaymentRequestDto;
import com.example.demo.dto.response.PaymentResponseDto;
import com.example.demo.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @PostMapping("/pay")
    public ResponseEntity<PaymentResponseDto> pay(@RequestBody PaymentRequestDto dto) {
        return ResponseEntity.ok(service.pay(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
