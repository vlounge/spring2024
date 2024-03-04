package com.vlad.springUrfuApp.persistence;

import jakarta.persistence.*;
import jdk.jfr.Name;
/**
 * Класс таблицы для хранения товаров в базе данных
 * id - Id товара
 * name- Название товара
 * maxPrice - Максимальная цена товара
 * incomePrice - Закупочная цена товара
 * amount - Количество товара(в штуках)
 * mainManagerConfirm - Подтверждение от главного менеджера
 * adminConfirm - Подтверждение от администратора
 *
 */
@Table(name="item")
@Entity
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;
    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "max_price")
    long maxPrice;
    @Column(name = "income_price")
    long incomePrice;
    @Column(name = "amount")
    long amount;
    @Column(name = "main_manager_confirm",columnDefinition = "boolean default false", nullable = false)
    boolean mainManagerConfirm;
    @Column(name = "admin_confirm",columnDefinition = "boolean default false", nullable = false)
    boolean adminConfirm;

    public  ItemEntity(){}

    public ItemEntity(String name, long maxPrice, long incomePrice, long amount, boolean mainManagerConfirm, boolean adminConfirm) {
        this.name = name;
        this.maxPrice = maxPrice;
        this.incomePrice = incomePrice;
        this.amount = amount;
        this.mainManagerConfirm = mainManagerConfirm;
        this.adminConfirm = adminConfirm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(long maxPrice) {
        this.maxPrice = maxPrice;
    }

    public long getIncomePrice() {
        return incomePrice;
    }

    public void setIncomePrice(long incomePrice) {
        this.incomePrice = incomePrice;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public boolean isMainManagerConfirm() {
        return mainManagerConfirm;
    }

    public void setMainManagerConfirm(boolean mainManagerConfirm) {
        this.mainManagerConfirm = mainManagerConfirm;
    }

    public boolean isAdminConfirm() {
        return adminConfirm;
    }

    public void setAdminConfirm(boolean adminConfirm) {
        this.adminConfirm = adminConfirm;
    }


}
