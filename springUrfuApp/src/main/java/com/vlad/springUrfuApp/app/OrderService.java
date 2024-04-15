package com.vlad.springUrfuApp.app;

import com.vlad.springUrfuApp.domain.AppUserEntity;
import com.vlad.springUrfuApp.domain.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Класс сервиса для работы с заказами
 */
@Service

@AllArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    /**
     * Метод создающий зака
     * @param orderEntity entity для нового заказа
     * @return id нового заказа из таблицы заказов
     */
    public OrderEntity newOrder(OrderEntity orderEntity){
        return orderRepository.save(orderEntity);
    }
}
