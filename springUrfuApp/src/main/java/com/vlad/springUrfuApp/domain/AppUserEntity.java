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

    public AppUserEntity(String ip, String city){
        this.ip = ip;
        this.city = city;
    }
}
