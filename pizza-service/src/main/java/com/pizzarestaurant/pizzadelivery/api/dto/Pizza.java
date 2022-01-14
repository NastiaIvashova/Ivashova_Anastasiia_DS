package com.pizzarestaurant.pizzadelivery.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Pizza
{
    private Long id_pizza;

    private String name;

    @Column(name = "size_cm")
    private int size;

    private BigDecimal price;

    private String description;

    @Column(name = "time_for_cook_minutes")
    private int time;

    @Column(name = "number_of_bonus")
    private BigDecimal bonus;

    private BigDecimal discounts;
}
