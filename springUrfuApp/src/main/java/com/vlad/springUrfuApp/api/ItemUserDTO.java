package com.vlad.springUrfuApp.api;
/**
 * Класс товара, используется для отображения
 * @param id Id товара
 * @param name Название товара
 * @param amount Количество товара(в штуках)
 * @param price Цена товара для пользователя
 *
 */

public record ItemUserDTO(
        long id,
        String name,
        long price,
        long amount
) {
}
