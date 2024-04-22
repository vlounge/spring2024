package com.vlad.springUrfuApp.domain;

import jakarta.persistence.*;
import lombok.*;

@Table(name="orders")
@Entity

@NoArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class OrderEntity {

    /**
     * ID заказа
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * ID покупателя
     */
    @Column(name = "buyer_id", nullable = false)
    private long buyerId;

    /**
     * Заказ готов к выдаче
     */
    @Column(name = "ready_for_issue", nullable = false)
    private boolean readyForIssue;

    /**
     * ID товара
     */
    @Column(name = "item_id", nullable = false)
    private long itemId;


    public OrderEntity(long buyerId, boolean readyForIssue, long itemId){
        this.buyerId = buyerId;
        this.readyForIssue = readyForIssue;
        this.itemId = itemId;
    }
}