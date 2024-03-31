package com.vlad.springUrfuApp.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 * Класс таблицы для хранения зарегистрированных пользователей в базе данных
 */
@Table(name="registered_user")
@Entity

@NoArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class RegisteredUserEntity {
    
    /**
     * ID зарегистрированного пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * ID пользователя из таблицы пользоателей
     */
    @Column(name = "user_id", nullable = false)
    private long userId;

    /**
     * Номер телефона зарегистрированного пользователя
     */
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;
    
    /**
     * Пароль зарегистрированного пользователя
     */
    @Column(name = "password", nullable = false)
    private String password;

    public RegisteredUserEntity(long userId, String phoneNumber, String password){
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
