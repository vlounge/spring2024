package com.vlad.springUrfuApp.service;

import com.vlad.springUrfuApp.api.ItemUserDTO;
import com.vlad.springUrfuApp.persistence.Item;

import com.vlad.springUrfuApp.persistence.ItemEntity;
import com.vlad.springUrfuApp.persistence.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * Класс работы с товаром
 * Обрабатывает отображение товаров, в зависимости от пользователя,
 * запросившего информацию о товаре.
 */
@Service
public class ItemService {
    private final Item domainItem;

    private final ItemRepository repository;
    /**
     * Конструктор сервиса
     */
    public ItemService(ItemRepository repository){
        domainItem = new Item(1,"Стать админом",0,0,1,true,true);
        this.repository = repository;
    }
    /**
     * Метод подучения получения информации о товаре
     * @return Информация о товаре
     */
    public ItemUserDTO getItem(){
        //Здесь будет логика сервиса
        return new ItemUserDTO(domainItem.id(),domainItem.name(),domainItem.maxPrice(),domainItem.amount());
    }
}
