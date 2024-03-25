package com.vlad.springUrfuApp.persistence;

import jakarta.persistence.*;
import lombok.*;

/**
 * Класс для хранения пользователей в базе данных
 */
@Table(name="app_user")
@Entity

@NoArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class AppUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ip")
    private String ip;

    @Column(name = "city")
    private String city;

    public AppUserEntity(String ip, String city){
        this.ip = ip;
        this.city = city;
    }
}
