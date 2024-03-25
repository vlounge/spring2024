package com.vlad.springUrfuApp.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
/**
 * Класс товара, используется для обычного пользователя
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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