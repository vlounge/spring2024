package com.vlad.springUrfuApp.domain;

import jakarta.persistence.*;
import lombok.*;

@Table(name="buyer")
@Entity

@NoArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class BuyerEntity {

    /**
     * ID покупателя
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
     * ID зарегистрированного пользователя из таблицы пользоателей
     */
    @Column(name = "reg_user_id")
    private long registeredUserId;

    /**
     * Номер телефона покупателя
     */
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    /**
     * Имя покупателя
     */
    @Column(name = "name", nullable = false)
    private String name;

    public BuyerEntity(long userId, String phoneNumber, String name){
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }
}