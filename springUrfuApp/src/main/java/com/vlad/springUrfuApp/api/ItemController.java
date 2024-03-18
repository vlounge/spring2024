package com.vlad.springUrfuApp.api;

import com.vlad.springUrfuApp.service.ItemAdminDTO;
import com.vlad.springUrfuApp.service.ItemService;
import com.vlad.springUrfuApp.service.ItemDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ItemAdminDTO postItemAdmin(@RequestBody ItemAdminDTO itemAdminDTO){
        return itemService.newItemAdmin(itemAdminDTO);
    }
}
