package com.vlad.springUrfuApp.extern;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Класс, запроса на регистрацию
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class UserRegistrationDTO {

    /**
     * IP-адрес пользователя
     */
    private String ip;

    /**
     * Город пользователя
     */
    private String city;

    /**
     * Номер телефона пользователя
     */
    private String phoneNumber;

    /**
     * Пароль пользователя
     */
    private String password;
}
