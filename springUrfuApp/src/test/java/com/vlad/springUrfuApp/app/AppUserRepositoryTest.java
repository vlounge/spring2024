package com.vlad.springUrfuApp.app;

import com.vlad.springUrfuApp.domain.AppUserEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class AppUserRepositoryTest {
    
    @Autowired
    AppUserRepository repository;
    
    @AfterEach
    void clearRepo(){
        repository.deleteAll();
    }
    
    @Test
    void saveAppUserTest(){
        AppUserEntity appUserEntity = new AppUserEntity("123.456.789.10", "Первоуральск");
        AppUserEntity returnedAppUserEntity = repository.save(appUserEntity);
        boolean testResult = returnedAppUserEntity.equals(appUserEntity);
        assertThat(testResult).isEqualTo(true);
    }
}