package com.vlad.springUrfuApp.persistence;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    private String password;

    public RegisteredUserEntity(long userId, String phoneNumber, String password){
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
