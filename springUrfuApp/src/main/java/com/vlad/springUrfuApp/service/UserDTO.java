package com.vlad.springUrfuApp.service;

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

    private String IP;

    private String city;
}
