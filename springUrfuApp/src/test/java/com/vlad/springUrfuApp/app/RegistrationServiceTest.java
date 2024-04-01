package com.vlad.springUrfuApp.app;

import com.vlad.springUrfuApp.domain.AppUserEntity;
import com.vlad.springUrfuApp.domain.RegisteredUserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RegistrationServiceTest {
    
    @Mock
    private AppUserRepository appUserRepository;
    @Mock
    private RegisteredUserRepository registeredUserRepository;
    RegistrationService testService;
    
    @BeforeEach
    void setUp(){
        testService = new RegistrationService(appUserRepository, registeredUserRepository);
    }
    
    @Test
    void canNewUser(){
        AppUserEntity appUserEntity = new AppUserEntity("123.456.789.10", "Первоуральск");
        testService.newUser(appUserEntity);
        verify(appUserRepository).save(appUserEntity);
    }
    
    @Test
    void canNewRegisteredUser(){
        RegisteredUserEntity registeredUserEntity = new RegisteredUserEntity(1, "+78901234567", "qwerty");
        testService.newRegisteredUser(registeredUserEntity);
        verify(registeredUserRepository).save(registeredUserEntity);
    }
}