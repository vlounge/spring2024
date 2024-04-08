package com.vlad.springUrfuApp.extern;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Класс заказа
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class OrderDTO {
    /**
     * Id незарегистрированного пользователя
     */
    private long userId;

    /**
     * Id зарегистрированного пользователя
     */
    private long regUserId;

    /**
     * Номер телефона покупателя
     */
    private String phoneNumber;

    /**
     * Имя покупателя
     */
    private String name;

    /**
     * Id товара
     */
    private long itemId;
}
