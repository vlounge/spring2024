package com.vlad.springUrfuApp.service;

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

    private String name;

    private long maxPrice;

    private long incomePrice;

    private long amount;

    private boolean mainManagerConfirm;

    private boolean adminConfirm;
}
