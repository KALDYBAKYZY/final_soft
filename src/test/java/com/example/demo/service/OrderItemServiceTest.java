package com.example.demo.service;

import com.example.demo.dto.response.OrderItemResponseDto;
import com.example.demo.entity.Book;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.mapper.OrderItemMapper;
import com.example.demo.repository.OrderItemRepository;
import com.example.demo.service.impl.OrderItemServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderItemServiceTest {

    @Mock
    private OrderItemRepository repository;

    private OrderItemMapper mapper = Mappers.getMapper(OrderItemMapper.class);

    @InjectMocks
    private OrderItemServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new OrderItemServiceImpl(repository, mapper);
    }

    @Test
    void testGetById() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Test Book");

        Order order = new Order();
        order.setId(1L);

        OrderItem item = new OrderItem();
        item.setId(1L);
        item.setBook(book);
        item.setOrder(order);
        item.setQuantity(2);
        item.setPrice(20.0);

        when(repository.findById(1L)).thenReturn(Optional.of(item));

        OrderItemResponseDto dto = service.getById(1L);

        assertNotNull(dto);
        assertEquals(1L, dto.getId());
        assertEquals("Harry Potter", dto.getBookTitle());
        assertEquals(2, dto.getQuantity());
        assertEquals(20.0, dto.getPrice());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testGetAll() {
        Book book1 = new Book();
        book1.setId(1L);
        book1.setTitle("Harry Potter");

        Book book2 = new Book();
        book2.setId(2L);
        book2.setTitle("Harry Potter 2");

        Order order = new Order();
        order.setId(1L);

        OrderItem item1 = new OrderItem();
        item1.setId(1L);
        item1.setBook(book1);
        item1.setOrder(order);
        item1.setQuantity(1);
        item1.setPrice(10.0);

        OrderItem item2 = new OrderItem();
        item2.setId(2L);
        item2.setBook(book2);
        item2.setOrder(order);
        item2.setQuantity(2);
        item2.setPrice(40.0);

        when(repository.findAll()).thenReturn(Arrays.asList(item1, item2));

        List<OrderItemResponseDto> list = service.getAll();

        assertEquals(2, list.size());
        assertEquals("Harry Potter", list.get(0).getBookTitle());
        assertEquals("Harry Potter 2", list.get(1).getBookTitle());
        verify(repository, times(1)).findAll();
    }
}
