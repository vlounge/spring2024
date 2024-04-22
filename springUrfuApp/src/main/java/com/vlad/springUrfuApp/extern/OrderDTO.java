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
     * Id пользователя, если незарегистрированный 0 или меньше
     */
    private long userId;

    /**
     * IP-адрес пользователя
     */
    private String ip;

    /**
     * Город пользователя
     */
    private String city;

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

    /**
     * Метод определения является ли пользователь новым,
     * true - пользователь новый
     * false - id зарегистрированного пользователя записывается в поле userId
     */
    public boolean isUserNew(){
        return userId<=0;
    };
}
