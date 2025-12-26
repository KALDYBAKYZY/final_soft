package com.example.demo.service;

import com.example.demo.dto.request.PaymentRequestDto;
import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.service.impl.PaymentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;

class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;
    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private PaymentServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPay() {
        PaymentRequestDto dto = new PaymentRequestDto();
        dto.setOrderId(1L);
        dto.setAmount(20.0);
        Order order = new Order();
        order.setId(1L);
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(paymentRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);
        when(orderRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);
        service.pay(dto);
        verify(paymentRepository, times(1)).save(any());
        verify(orderRepository, times(1)).save(any());
    }
}
