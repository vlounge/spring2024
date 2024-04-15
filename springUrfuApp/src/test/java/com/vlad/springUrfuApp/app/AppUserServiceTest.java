package com.vlad.springUrfuApp.app;

import com.vlad.springUrfuApp.domain.AppUserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AppUserServiceTest {
    
    @Mock
    private AppUserRepository appUserRepository;
    AppUserService testService;
    
    @BeforeEach
    void setUp(){
        testService = new AppUserService(appUserRepository);
    }
    
    @Test
    void canNewUser(){
        AppUserEntity appUserEntity = new AppUserEntity("123.456.789.10", "Первоуральск", "+70000000000", "Петя", "password");
        testService.newUser(appUserEntity);
        verify(appUserRepository).save(appUserEntity);
    }
    

}