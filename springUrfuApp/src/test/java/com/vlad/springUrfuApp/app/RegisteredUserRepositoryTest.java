package com.vlad.springUrfuApp.app;

import com.vlad.springUrfuApp.domain.RegisteredUserEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class RegisteredUserRepositoryTest {
    
    @Autowired
    RegisteredUserRepository repository;
    
    @AfterEach
    void clearRepo(){
        repository.deleteAll();
    }
    
    @Test
    void saveRegisteredUserTest(){
        RegisteredUserEntity registeredUserEntity = new RegisteredUserEntity(1, "+78901234567", "qwerty");
        RegisteredUserEntity returnedRegisteredUserEntity = repository.save(registeredUserEntity);
        boolean testResult = returnedRegisteredUserEntity.equals(registeredUserEntity);
        assertThat(testResult).isEqualTo(true);
    }
}