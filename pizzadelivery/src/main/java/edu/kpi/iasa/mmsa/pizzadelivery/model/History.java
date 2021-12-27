package edu.kpi.iasa.mmsa.pizzadelivery.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "history_order")
public class History
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_history")
    private long idHistory;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id_user")
    private User userId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pizza_id", referencedColumnName = "id_pizza")
    private Pizza pizzaId;

    @Column(name = "amount_pizza")
    private int amountPizza;

    @ManyToOne(optional = false)
    @JoinColumn(name = "status", referencedColumnName = "id_status")
    private Status statusId;

    @Column(name = "order_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;

    @Column(name = "delivery_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deliveryDate;

    @Column(name = "comment_customer")
    private String comment;

    public long getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(long idHistory) {
        this.idHistory = idHistory;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Pizza getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Pizza pizzaId) {
        this.pizzaId = pizzaId;
    }

    public int getAmountPizza() {
        return amountPizza;
    }

    public void setAmountPizza(int amountPizza) {
        this.amountPizza = amountPizza;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
