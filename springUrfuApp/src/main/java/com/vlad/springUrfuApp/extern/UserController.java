package com.vlad.springUrfuApp.extern;

import com.vlad.springUrfuApp.app.AppUserService;
import com.vlad.springUrfuApp.domain.AppUserEntity;
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
    private final AppUserService appUserService;
    
    /**
     * Метод регистрации нового пользователя
     * @return Данные о пользователе
     */
    @PostMapping
    public UserRegistrationDTO postItemAdmin(@RequestBody UserRegistrationDTO registrationDTO){
        AppUserEntity appUserEntity = appUserService.newUser(new AppUserEntity(
                registrationDTO.getIp(),
                registrationDTO.getCity(),
                registrationDTO.getPhoneNumber(),
                null,
                registrationDTO.getPassword()
                )

        );
        return UserRegistrationDTO.builder()
                .ip(registrationDTO.getIp())
                .city(registrationDTO.getCity())
                .phoneNumber(registrationDTO.getPhoneNumber())
                .password("***")
                .build();
    }
}
