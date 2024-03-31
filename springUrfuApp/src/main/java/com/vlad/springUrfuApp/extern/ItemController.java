package com.vlad.springUrfuApp.extern;

import com.vlad.springUrfuApp.app.ItemService;
import com.vlad.springUrfuApp.domain.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс контоллера, для работы с товаром.
 */
@RestController
@RequestMapping("/api/items")

@AllArgsConstructor
@Slf4j
public class ItemController {
    private final ItemService itemService;

    /**
     * Метод запроса товаров
     * @return Данные о всех товарах для пользователя без специальных прав
     */
    @GetMapping
    public ItemDTO[] getItems(){
        List<ItemEntity> itemEntityList = itemService.getAdminConfirmedItems();
        ItemDTO[] itemDTOArray = new ItemDTO[itemEntityList.size()];
        int i = 0;
        for (ItemEntity ie : itemEntityList){
            log.trace("Item entity {} {}", i, ie);
            itemDTOArray[i] = ItemDTO.builder()
                    .name(ie.getName())
                    .price(ie.getMaxPrice())
                    .amount(ie.getAmount())
                    .build();
            log.trace("Item DTO {} {}", i, itemDTOArray[i]);
            i++;
        }
        return itemDTOArray;
    }

    /**
     * Метод добавления товара администратором
     * @return Добавленный товар
     */
    @PostMapping
    public ItemAdminDTO postItemAdmin(@RequestBody ItemAdminDTO itemAdminDTO){
        ItemEntity itemEntity = itemService.newItemAdmin(new ItemEntity(
                itemAdminDTO.getName(),
                itemAdminDTO.getMaxPrice(),
                itemAdminDTO.getIncomePrice(),
                itemAdminDTO.getAmount(),
                itemAdminDTO.isMainManagerConfirm(),
                itemAdminDTO.isAdminConfirm()
        ));
        return ItemAdminDTO.builder()
                .name(itemEntity.getName())
                .maxPrice(itemEntity.getMaxPrice())
                .incomePrice(itemEntity.getIncomePrice())
                .amount(itemEntity.getAmount())
                .mainManagerConfirm(itemEntity.isMainManagerConfirm())
                .adminConfirm(itemEntity.isAdminConfirm())
                .build();
    }
}
