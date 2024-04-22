package com.vlad.springUrfuApp.app;

import com.vlad.springUrfuApp.domain.OrderEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class OrderRepositoryTest {
    @Autowired
    OrderRepository repository;

    @AfterEach
    void clearRepo(){
        repository.deleteAll();
    }

    @Test
    void saveOrderTest(){
        OrderEntity orderEntity = new OrderEntity(1,true,1);
        OrderEntity returnedOrderEntity = repository.save(orderEntity);
        boolean testResult = returnedOrderEntity.equals(orderEntity);
        assertThat(testResult).isEqualTo(true);
    }
}