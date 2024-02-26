package com.vlad.springUrfuApp.persistence;
/**
 * Класс товара, используется для бизнес-логики(слой service)
 * @param id Id товара
 * @param name Название товара
 * @param maxPrice Максимальная цена товара
 * @param incomePrice Закупочная цена товара
 * @param amount Количество товара(в штуках)
 * @param mainManagerConfirm Подтверждение от главного менеджера
 * @param adminConfirm Подтверждение от администратора
 *
 */
public record  Item(

        long id,
        String name,
        long maxPrice,
        long incomePrice,
        long amount,
        boolean mainManagerConfirm,
        boolean adminConfirm
) {
}
