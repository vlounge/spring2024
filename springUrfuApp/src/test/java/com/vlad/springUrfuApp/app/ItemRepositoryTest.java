package com.vlad.springUrfuApp.app;

import com.vlad.springUrfuApp.domain.ItemEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class ItemRepositoryTest {
    
    @Autowired
    ItemRepository repository;
    
    @AfterEach
    void clearRepo(){
        repository.deleteAll();
    }
    
    @Test
    void getItemsConfirmedByAdminTest(){
        ItemEntity confirmedItemEntity = new ItemEntity("Книга", 1000, 100, 2, true, true);
        ItemEntity notConfirmedItemEntity = new ItemEntity("Неподтвержденная книга", 10000, 1000, 10, true, false);
        repository.save(confirmedItemEntity);
        repository.save(notConfirmedItemEntity);
        List<ItemEntity> returnedItemEntityList = repository.findAllConfirmedByAdmin();
        if(!returnedItemEntityList.isEmpty()){
            boolean testResult = returnedItemEntityList.getFirst().equals(confirmedItemEntity);
            assertThat(testResult).isEqualTo(true);
        }
        assertThat(returnedItemEntityList.size()).isEqualTo(1);
        
    }
    
    @Test
    void saveItemTest(){
        ItemEntity itemEntity = new ItemEntity("Книга", 1000, 100, 2, true, true);
        ItemEntity returnedItemEntity = repository.save(itemEntity);
        boolean testResult = returnedItemEntity.equals(itemEntity);
        assertThat(testResult).isEqualTo(true);
    }
}