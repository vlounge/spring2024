package com.vlad.springUrfuApp.extern;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Класс, незарегистрированного пользователя
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class UserDTO {

    /**
     * IP-адрес пользователя
     */
    private String IP;

    /**
     * Город пользователя
     */
    private String city;
}
