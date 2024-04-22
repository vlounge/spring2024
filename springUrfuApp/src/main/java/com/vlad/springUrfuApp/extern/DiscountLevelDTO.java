package com.vlad.springUrfuApp.extern;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Класс, определяющий уровень скидуи
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class DiscountLevelDTO {
    /**
     * Название уровня скидки
     */
    private String levelDiscountName;

    /**
     * Скидка
     */
    private long discount;
}
