package com.vlad.springUrfuApp.persistence;

import jakarta.persistence.*;
import lombok.*;

/**
 * Класс таблицы для хранения товаров в базе данных
 * id - Id товара
 * name - Название товара
 * maxPrice - Максимальная цена товара
 * incomePrice - Закупочная цена товара
 * amount - Количество товара(в штуках)
 * mainManagerConfirm - Подтверждение от главного менеджера
 * adminConfirm - Подтверждение от администратора
 *
 */
@Table(name="item")
@Entity

@NoArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "max_price")
    private long maxPrice;

    @Column(name = "income_price")
    private long incomePrice;

    @Column(name = "amount")
    private long amount;

    @Column(name = "main_manager_confirm",columnDefinition = "boolean default false", nullable = false)
    private boolean mainManagerConfirm;

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
