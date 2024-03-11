package com.vlad.springUrfuApp.api;

import com.vlad.springUrfuApp.service.ItemService;
import com.vlad.springUrfuApp.service.ItemDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Класс контоллера, для работы с товаром.
 */
@RestController
@RequestMapping("/api/items")

@AllArgsConstructor
public class ItemController {
    private final ItemService itemService;

    /**
     * Метод запроса товаров
     * @return Данные о товарах
     */
    @GetMapping
    public ItemDTO[] getItems(){
        return itemService.getItems();
    }
}
