package com.vlad.springUrfuApp.domain;

import jakarta.persistence.*;
import lombok.*;

@Table(name="order")
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


    public OrderEntity(long buyerId, boolean readyForIssue){
        this.buyerId = buyerId;
        this.readyForIssue = readyForIssue;
    }
}