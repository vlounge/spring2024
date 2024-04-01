package com.vlad.springUrfuApp.app;

import com.vlad.springUrfuApp.domain.ItemEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {
    
    @Mock
    private ItemRepository itemRepository;
    ItemService testService;
    
    @BeforeEach
    void setUp(){
        testService = new ItemService(itemRepository);
    }
    
    @Test
    void canGetAdminConfirmedItems(){
        testService.getAdminConfirmedItems();
        verify(itemRepository).findAllConfirmedByAdmin();
    }
    
    @Test
    void canNewItemAdmin(){
        ItemEntity testItemEntity = new ItemEntity("Книга", 1000, 100, 2, true, true);
        testService.newItemAdmin(testItemEntity);
        verify(itemRepository).save(testItemEntity);
    }
}