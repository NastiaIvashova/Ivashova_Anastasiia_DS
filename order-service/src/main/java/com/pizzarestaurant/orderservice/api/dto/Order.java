package com.pizzarestaurant.orderservice.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Order
{
    @Column(name = "id_order")
    private Long idOrder;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "pizza_id")
    private Long pizzaId;

    @Column(name = "amount_pizza")
    private int amountPizza;

    @Column(name = "order_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;

    @Column(name = "delivery_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deliveryDate;

    private String city;

    private String street;

    @Column(name = "street_number")
    private int number;

    @Column(name = "entrance_street")
    private int entrance;

    @Column(name = "comment")
    private String comment;

    private String status;
}
