package com.example.demo.service;

import com.example.demo.dto.request.OrderItemRequestDto;
import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.entity.Book;
import com.example.demo.entity.Order;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.OrderItemRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private OrderItemRepository orderItemRepository;
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private OrderServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateOrder() {
        OrderRequestDto dto = new OrderRequestDto();
        OrderItemRequestDto itemDto = new OrderItemRequestDto();
        itemDto.setBookId(1L);
        itemDto.setQuantity(2);
        dto.setItems(Collections.singletonList(itemDto));


        Book book = new Book();
        book.setId(1L);
        book.setPrice(10.0);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(orderRepository.save(any(Order.class))).thenAnswer(i -> i.getArguments()[0]);

        service.create(dto);

        verify(orderRepository, times(2)).save(any(Order.class)); // один раз заказ, один раз обновление с items
    }
}
