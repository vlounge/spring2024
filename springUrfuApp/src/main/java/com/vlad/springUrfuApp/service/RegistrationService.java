package com.vlad.springUrfuApp.service;

import com.vlad.springUrfuApp.persistence.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Класс сервиса для регистрации пользователя
 */
@Service

@AllArgsConstructor
@Slf4j
public class RegistrationService {

    private final AppUserRepository userRepository;

    private final RegisteredUserRepository registeredUserRepository;

    public RegistrationDTO newRegisteredUser(RegistrationDTO registrationDTO){

        AppUserEntity userEntity = new AppUserEntity(
                registrationDTO.getIp(),
                registrationDTO.getCity()
        );

        log.info("User entity {}",userEntity );
        long userId = userRepository.save(userEntity).getId();

        RegisteredUserEntity registeredUserEntity = new RegisteredUserEntity(
                userId,
                registrationDTO.getPhoneNumber(),
                registrationDTO.getPassword()
        );
        log.info("Registered user entity {}",registeredUserEntity );
        registeredUserRepository.save(registeredUserEntity);
        return registrationDTO;
    }
}
