package com.vlad.springUrfuApp.service;

import lombok.Data; /**
 * Класс товара, используется для отображения
 */
@Data
public class ItemDTO {
    /**
     * Название товара
     */
    private String name;
    /**
     * Количество товара(в штуках)
     */
    private long price;
    /**
     * Цена товара для пользователя
     */
    private long amount;
}