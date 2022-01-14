package com.pizzarestaurant.orderservice.service;


import com.pizzarestaurant.orderservice.repository.model.Order;
import com.pizzarestaurant.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderService
{
    public final OrderRepository orderRepository;
    public List<Order> fetchAll(){
        return orderRepository.findAll();
    }

    public Order fetchById(Long idOrder) throws IllegalArgumentException
    {
        final Optional<Order> maybeOrder = orderRepository.findById(idOrder);

        if (maybeOrder.isEmpty()) throw new IllegalArgumentException("Order is not found");
        else return maybeOrder.get();
    }

    public long create(Long userId, Long pizzaId, int amountPizza, LocalDateTime orderDate, LocalDateTime deliveryDate, String city, String street, int number, int entrance, String comment, String status)
    {
        final Order order = new Order(userId, pizzaId, amountPizza, orderDate, deliveryDate, city, street, number, entrance, comment, status);
        final Order savedOrder = orderRepository.save(order);

        return savedOrder.getIdOrder();
    }

    public void update(Long idOrder, Long userId, Long pizzaId, int amountPizza, LocalDateTime orderDate, LocalDateTime deliveryDate, String city, String street, int number, int entrance, String comment, String status) throws IllegalArgumentException
    {
        final Optional<Order> maybeOrder = orderRepository.findById(idOrder);
        if (maybeOrder.isEmpty()) throw new IllegalArgumentException("Order is not found");

        final Order order = maybeOrder.get();
        if(userId != null) order.setUserId(userId);
        if(pizzaId != null) order.setPizzaId(pizzaId);
        if(amountPizza != 0) order.setAmountPizza(amountPizza);
        if(orderDate != null) order.setOrderDate(orderDate);
        if(deliveryDate != null) order.setDeliveryDate(deliveryDate);
        if(city != null && !city.isBlank()) order.setCity(city);
        if(street != null && !street.isBlank()) order.setStreet(street);
        if(number != 0) order.setNumber(number);
        if(entrance != 0) order.setEntrance(entrance);
        if(comment != null && !comment.isBlank()) order.setComment(comment);
        if(status != null && !status.isBlank()) order.setStatus(status);
        orderRepository.save(order);
    }

    public void delete(Long idOrder)
    {
        orderRepository.deleteById(idOrder);
    }
}
