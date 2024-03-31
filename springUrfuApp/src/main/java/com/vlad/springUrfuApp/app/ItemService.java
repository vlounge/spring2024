package com.vlad.springUrfuApp.app;

import com.vlad.springUrfuApp.domain.ItemEntity;
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
    
    private final ItemRepository itemRepository;
    
    /**
     * Метод возвращающий товары подтвержденные администратором
     * @return лист всех товаров подтвержденных администратором
     */
    public List<ItemEntity> getAdminConfirmedItems(){
        return itemRepository.findAllConfirmedByAdmin();
    }
    
    /**
     * Метод создающий товар
     * @param itemAdmin entity для нового товара
     * @return entity нового товара
     */
    public ItemEntity newItemAdmin(ItemEntity itemAdmin){
        return itemRepository.save(itemAdmin);
    }
}
