package com.vlad.springUrfuApp.app;

import com.vlad.springUrfuApp.domain.AppUserEntity;
import com.vlad.springUrfuApp.domain.RegisteredUserEntity;
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
    
    /**
     * Метод создающий пользователя
     * @param userEntity entity для нового пользователя
     * @return id нового пользователя из таблицы пользователей
     */
    public AppUserEntity newUser(AppUserEntity userEntity){
        return userRepository.save(userEntity);
    }
    
    /**
     * Метод создающий пользователя
     * @param registeredUserEntity entity для нового зарегистрированного пользователя
     * @return entity нового зарегистрированного пользователя
     */
    public RegisteredUserEntity newRegisteredUser(RegisteredUserEntity registeredUserEntity){
        
        return registeredUserRepository.save(registeredUserEntity);
    }
}
