package com.vlad.springUrfuApp.app;

import com.vlad.springUrfuApp.domain.DiscountLevelEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
public class DiscountLevelRepositoryTest {
    @Autowired
    DiscountLevelRepository repository;

    @AfterEach
    void clearRepo(){
        repository.deleteAll();
    }

    @Test
    void saveDiscountLevel(){
        DiscountLevelEntity discountLevelEntity = new DiscountLevelEntity("Бронзовый",5);
        DiscountLevelEntity returnedDiscountLevelEntity = repository.save(discountLevelEntity);
        boolean testResult = returnedDiscountLevelEntity.equals(discountLevelEntity);
        assertThat(testResult).isEqualTo(true);
    }

}