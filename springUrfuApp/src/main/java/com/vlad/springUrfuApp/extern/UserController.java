package com.vlad.springUrfuApp.extern;

import com.vlad.springUrfuApp.app.RegistrationService;
import com.vlad.springUrfuApp.domain.AppUserEntity;
import com.vlad.springUrfuApp.domain.RegisteredUserEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Класс контоллера, для работы с пользователями
 */
@RestController
@RequestMapping("/api/users")

@AllArgsConstructor
@Slf4j
public class UserController {
    private final RegistrationService registrationService;
    
    /**
     * Метод регистрации нового пользователя
     * @return Данные о зарегистрированном пользователе
     */
    @PostMapping
    public UserRegistrationDTO postItemAdmin(@RequestBody UserRegistrationDTO registrationDTO){
        AppUserEntity appUserEntity = registrationService.newUser(new AppUserEntity(
                registrationDTO.getIp(),
                registrationDTO.getCity())
        );
        RegisteredUserEntity registeredUserEntity = registrationService.newRegisteredUser(
                    new RegisteredUserEntity(
                            appUserEntity.getId(),
                            registrationDTO.getPhoneNumber(),
                            registrationDTO.getPassword()
                            )
                );       
        return UserRegistrationDTO.builder()
                .ip(registrationDTO.getIp())
                .city(registrationDTO.getCity())
                .phoneNumber(registeredUserEntity.getPhoneNumber())
                .password(registeredUserEntity.getPassword())
                .build();
    }
}
