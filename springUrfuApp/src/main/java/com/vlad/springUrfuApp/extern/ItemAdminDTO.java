package com.vlad.springUrfuApp.extern;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Класс товара, используется для администратора
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class ItemAdminDTO {
    
    /**
     * Название товара
     */
    private String name;
    
    /**
     * Розничная цена товара
     */
    private long maxPrice;

    /**
     * Входящая цена товара
     */
    private long incomePrice;

    /**
     * Количество товара
     */
    private long amount;

    /**
     * Подтверждение главного менеджера
     */
    private boolean mainManagerConfirm;

    /**
     * Подтверждение администратора
     */
    private boolean adminConfirm;
}
