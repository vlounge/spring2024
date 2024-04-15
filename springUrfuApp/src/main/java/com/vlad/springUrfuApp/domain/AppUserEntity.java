package com.vlad.springUrfuApp.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 * Класс таблицы для хранения пользователей в базе данных
 */
@Table(name="app_user")
@Entity

@NoArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class AppUserEntity {

    /**
     * ID пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    /**
     * IP-адрес пользователя
     */
    @Column(name = "ip")
    private String ip;

    /**
     * Город пользователя
     */
    @Column(name = "city")
    private String city;

    /**
     * Номер телефона пользователя
     */
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    /**
     * Имя пользователя
     */
    @Column(name = "name")
    private String name;

    /**
     * Пароль пользователя
     */
    @Column(name = "password", nullable = false)
    private String password;

    public AppUserEntity(String ip, String city, String phoneNumber, String name, String password){
        this.ip = ip;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.password =password;
    }
}
