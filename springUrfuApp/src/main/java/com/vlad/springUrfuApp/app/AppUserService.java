package com.vlad.springUrfuApp.app;

import com.vlad.springUrfuApp.domain.AppUserEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Класс сервиса для регистрации пользователей и работы с ними
 */
@Service

@AllArgsConstructor
@Slf4j
public class AppUserService {

    private final AppUserRepository userRepository;

    /**
     * Метод создающий пользователя
     * @param userEntity entity для нового пользователя
     * @return id нового пользователя из таблицы пользователей
     */
    public AppUserEntity newUser(AppUserEntity userEntity){
        return userRepository.save(userEntity);
    }

}
