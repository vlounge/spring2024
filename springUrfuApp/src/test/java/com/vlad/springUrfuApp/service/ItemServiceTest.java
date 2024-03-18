package com.vlad.springUrfuApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Тесты ItemService
 */
@SpringBootTest
class ItemServiceTest {

    @Autowired
    ItemService service;

    /**
     * Тест записи первго товара в базу данных, с помощью сервиса
     */
    @Test
    public void newItemTest(){
        ItemAdminDTO itemAdminDTO = new ItemAdminDTO();
        itemAdminDTO.setName("Книга");
        itemAdminDTO.setMaxPrice(1000);
        itemAdminDTO.setIncomePrice(100);
        itemAdminDTO.setAmount(2);
        itemAdminDTO.setMainManagerConfirm(true);
        itemAdminDTO.setAdminConfirm(true);
        service.newItemAdmin(itemAdminDTO);
        ItemDTO itemDTOFromService = service.getItems()[0];
        assertThat(itemDTOFromService.getName()).isEqualTo(itemAdminDTO.getName()).isNotBlank();
        assertThat(itemDTOFromService.getPrice()).isEqualTo(itemAdminDTO.getMaxPrice());
        assertThat(itemDTOFromService.getAmount()).isEqualTo(itemAdminDTO.getAmount());
    }
}