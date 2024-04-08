package com.vlad.springUrfuApp.domain;

import jakarta.persistence.*;
import lombok.*;
@Table(name="order_item")
@Entity
/**
 * Связь заказа и товара
 */
@NoArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class OrderItemLinkEntity {
    /**
     * Id связи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * ID заказа
     */
    @Column(name = "order_id", nullable = false)
    private long orderId;

    /**
     * ID товара
     */
    @Column(name = "item_id", nullable = false)
    private long itemId;

    public OrderItemLinkEntity(long orderId, long itemId){
        this.orderId = orderId;
        this.itemId = itemId;
    }
}