package com.vlad.springUrfuApp.app;

import com.vlad.springUrfuApp.domain.AppUserEntity;
import com.vlad.springUrfuApp.domain.BuyerEntity;
import com.vlad.springUrfuApp.domain.ItemEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BuyerRepositoryTest {
    @Autowired
    BuyerRepository repository;

    @AfterEach
    void clearRepo(){
        repository.deleteAll();
    }

    @Test
    void saveBuyerTest() {
        BuyerEntity buyerEntity = new BuyerEntity(0, "89000000222", "Vlad");
        BuyerEntity returnedBuyerEntity = repository.save(buyerEntity);
        boolean testResult = returnedBuyerEntity.equals(buyerEntity);
        assertThat(testResult).isEqualTo(true);
    }
}
