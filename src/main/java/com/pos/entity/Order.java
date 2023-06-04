package com.pos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name="orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;
    private Double total;

}
