package com.vlad.springUrfuApp.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 * Класс таблицы для хранения товаров в базе данных
 */
@Table(name="item")
@Entity

@NoArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class ItemEntity {
    /**
     * Id товара
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Название товара
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Максимальная цена товара
     */
    @Column(name = "max_price")
    private long maxPrice;

    /**
     * Закупочная цена товара
     */
    @Column(name = "income_price")
    private long incomePrice;

    /**
     * Количество товара(в штуках)
     */
    @Column(name = "amount")
    private long amount;

    /**
     * Подтверждение от главного менеджера
     */
    @Column(name = "main_manager_confirm",columnDefinition = "boolean default false", nullable = false)
    private boolean mainManagerConfirm;

    /**
     * Подтверждение от администратора
     */
    @Column(name = "admin_confirm",columnDefinition = "boolean default false", nullable = false)
    private boolean adminConfirm;

    public ItemEntity(String name, long maxPrice, long incomePrice, long amount, boolean mainManagerConfirm, boolean adminConfirm) {
        this.name = name;

        this.maxPrice = maxPrice;

        this.incomePrice = incomePrice;

        this.amount = amount;

        this.mainManagerConfirm = mainManagerConfirm;

        this.adminConfirm = adminConfirm;
    }
}
