package com.vlad.springUrfuApp.service;

import com.vlad.springUrfuApp.api.ItemUserDTO;
import com.vlad.springUrfuApp.persistence.Item;

/**
 * Класс работы с товаром
 * Обрабатывает отображение товаров, в зависимости от пользователя,
 * запросившего информацию о товаре.
 */
public class ItemService {
    /**
     * Метод подучения получения информации о товаре
     * @return Информация о товаре
     */
    public ItemUserDTO GetItem(){
        Item domainItem =  new Item(1,"Стать админом",0,0,1,true,true);
        //Здесь будет логика сервиса
        return new ItemUserDTO(domainItem.id(),domainItem.name(),domainItem.maxPrice(),domainItem.amount());
    }
}
