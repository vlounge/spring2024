package com.vlad.springUrfuApp.app;

import com.vlad.springUrfuApp.domain.AppUserEntity;
import com.vlad.springUrfuApp.domain.OrderEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;
    OrderService testService;

    @BeforeEach
    void setUp(){
        testService = new OrderService(orderRepository);
    }

    @Test
    void canNewOrder(){
        OrderEntity orderEntity = new OrderEntity(1,true,1);
        testService.newOrder(orderEntity);
        verify(orderRepository).save(orderEntity);
    }
}