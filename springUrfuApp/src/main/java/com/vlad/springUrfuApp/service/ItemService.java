package com.vlad.springUrfuApp.service;

import com.vlad.springUrfuApp.persistence.ItemEntity;
import com.vlad.springUrfuApp.persistence.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс работы с товаром
 * Обрабатывает отображение товаров, в зависимости от пользователя,
 * запросившего информацию о товаре.
 */
@Service

@AllArgsConstructor
@Slf4j
public class ItemService {

    private final ItemRepository repository;

    /**
     * Метод подучения получения информации о товарах
     * @return Информация о товарах
     */
    public ItemDTO[] getItems(){
        //Здесь будет логика сервиса
        List<ItemEntity> itemEntityList = repository.findAll();
        ItemDTO[] itemDTOArray = new ItemDTO[itemEntityList.size()];
        ItemDTO.ItemDTOBuilder itemDTOBuilder;
        int i = 0;
        for (ItemEntity ie : itemEntityList){
            log.info("Item entity {} {}", i, ie);
            itemDTOBuilder = ItemDTO.builder()
                    .name(ie.getName())
                    .price(ie.getMaxPrice())
                    .amount(ie.getAmount());
            itemDTOArray[i] = itemDTOBuilder.build();
            log.info("Item DTO {} {}", i, itemDTOArray[i]);
            i++;
        }
        return itemDTOArray;
    }

    /**
     * Метод создающий
     * @param itemAdminDTO
     * @return
     */
    public ItemAdminDTO newItemAdmin(ItemAdminDTO itemAdminDTO){
        ItemEntity itemEntity = new ItemEntity(
                itemAdminDTO.getName(),
                itemAdminDTO.getMaxPrice(),
                itemAdminDTO.getIncomePrice(),
                itemAdminDTO.getAmount(),
                itemAdminDTO.isMainManagerConfirm(),
                itemAdminDTO.isAdminConfirm()
        );
        log.info("Item entity {}",itemEntity );
        repository.save(itemEntity);
        return itemAdminDTO;
    }
}
