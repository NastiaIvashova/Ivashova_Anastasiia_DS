package com.pizzarestaurant.pizzadelivery.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pizza")
public class Pizza
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Long getId_pizza() {
        return id_pizza;
    }

    public void setId_pizza(Long id_pizza) {
        this.id_pizza = id_pizza;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public BigDecimal getDiscounts() {
        return discounts;
    }

    public void setDiscounts(BigDecimal discounts) {
        this.discounts = discounts;
    }
}
