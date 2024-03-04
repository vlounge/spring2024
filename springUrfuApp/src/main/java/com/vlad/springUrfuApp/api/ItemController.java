package com.vlad.springUrfuApp.api;

import com.vlad.springUrfuApp.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Класс контоллера, для работы с товаром.
 */
@RestController
public class ItemController {
    /**
     * Метод запроса товаров
     * @return Данные о товарах
     */
    @GetMapping("/api/items")
    public ItemUserDTO getItem(ItemService itemService){
        //ItemService testService = new ItemService();
        //return testService.GetItem();
        return itemService.getItem();
        //return new Item(1,"Стать админом",0,0,1,true,true);
    }
}
