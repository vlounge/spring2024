package com.vlad.springUrfuApp.service;

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
public class RegistrationDTO {

    private String ip;

    private String city;

    private String phoneNumber;

    private String password;
}
