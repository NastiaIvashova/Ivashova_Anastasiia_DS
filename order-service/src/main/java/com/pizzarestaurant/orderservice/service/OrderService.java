package com.pizzarestaurant.orderservice.service;

import com.pizzarestaurant.orderservice.exception.OrderNotFoundException;
import com.pizzarestaurant.orderservice.model.Order;
import com.pizzarestaurant.orderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class OrderService
{
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository)
    {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders ()
    {
        return orderRepository.findAll();
    }

    public Order saveOrder(Order newOrder)
    {
        return orderRepository.save(newOrder);
    }

    public Order getOrderById(Long id_order) throws IllegalArgumentException
    {
        Optional<Order> order = orderRepository.findById(id_order);
        if (order.isPresent())
        {
            log.info("order: {}", order.get());
            return order.get();
        }
        throw new OrderNotFoundException();
    }

    public Order updateOrderById(Long id_order, Order updatedOrder) throws IllegalArgumentException
    {
        Optional<Order> order = orderRepository.findById(id_order);
        if (order.isPresent()) {
            Order oldOrder = order.get();
            log.info("order: {}", oldOrder);
            updateOrder(oldOrder, updatedOrder);
            return orderRepository.save(oldOrder);
        }
        throw new OrderNotFoundException();
    }

    private void updateOrder(Order oldOrder, Order updatedOrder)
    {
        oldOrder.setPizzaId(updatedOrder.getPizzaId());
        oldOrder.setAmountPizza(updatedOrder.getAmountPizza());
        oldOrder.setOrderDate(updatedOrder.getOrderDate());
        oldOrder.setDeliveryDate(updatedOrder.getDeliveryDate());
        oldOrder.setCity(updatedOrder.getCity());
        oldOrder.setStreet(updatedOrder.getStreet());
        oldOrder.setNumber(updatedOrder.getNumber());
        oldOrder.setEntrance(updatedOrder.getEntrance());
        oldOrder.setComment(updatedOrder.getComment());
        oldOrder.setStatus(updatedOrder.getStatus());
    }

    public String deleteOrderById(Long id_order)
    {
        orderRepository.deleteById(id_order);
        return "Order was successfully deleted!";
    }
}
