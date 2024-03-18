package com.vlad.springUrfuApp.service;

import lombok.Data;

/**
 * Класс товара, используется для администратора
 */
@Data
public class ItemAdminDTO {

    private String name;

    private long maxPrice;

    private long incomePrice;

    private long amount;

    private boolean mainManagerConfirm;

    private boolean adminConfirm;
}
