package com.pizzarestaurant.orderservice.repository.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "`order`", schema = "service-order")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Order()
    {

    }

    public Order(Long userId, Long pizzaId, int amountPizza, LocalDateTime orderDate, LocalDateTime deliveryDate, String city, String street, int number, int entrance, String comment, String status)
    {
        this.userId = userId;
        this.pizzaId = pizzaId;
        this.amountPizza = amountPizza;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.city = city;
        this.street = street;
        this.number = number;
        this.entrance = entrance;
        this.comment = comment;
        this.status = status;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Long pizzaId) {
        this.pizzaId = pizzaId;
    }

    public int getAmountPizza() {
        return amountPizza;
    }

    public void setAmountPizza(int amountPizza) {
        this.amountPizza = amountPizza;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getEntrance() {
        return entrance;
    }

    public void setEntrance(int entrance) {
        this.entrance = entrance;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
