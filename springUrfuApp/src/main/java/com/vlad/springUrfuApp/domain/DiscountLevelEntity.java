package com.vlad.springUrfuApp.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 * Класс таблицы бля хранения уровней скидки
 */
@Table(name="discount_level")
@Entity

@NoArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class DiscountLevelEntity {
    /**
     * Id уровня скидки
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Название уровня скидки
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Скидка
     */
    @Column(name = "discount")
    private long discount;

    public DiscountLevelEntity(String name, long discount) {
        this.name = name;
        this.discount = discount;
    }

}
