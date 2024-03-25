package com.vlad.springUrfuApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Тесты RegistrationService
 */
@SpringBootTest
class RegistrationServiceTest {

    @Autowired
    RegistrationService service;

    @Test
    public void newUserTest(){
        RegistrationDTO registrationDTO = RegistrationDTO
                .builder()
                .ip("123.456.789.1")
                .city("Ревда")
                .phoneNumber("+71234567890")
                .password("password")
                .build();
        RegistrationDTO returnedDTO = service.newRegisteredUser(registrationDTO);
        assertThat(returnedDTO.getIp()).isEqualTo(registrationDTO.getIp());
        assertThat(returnedDTO.getCity()).isEqualTo(registrationDTO.getCity());
        assertThat(returnedDTO.getPhoneNumber()).isEqualTo(registrationDTO.getPhoneNumber()).isNotBlank();
        assertThat(returnedDTO.getPassword()).isEqualTo(registrationDTO.getPassword()).isNotBlank();
    }
}