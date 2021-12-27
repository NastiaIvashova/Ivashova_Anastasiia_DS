package edu.kpi.iasa.mmsa.pizzadelivery.service;

import edu.kpi.iasa.mmsa.pizzadelivery.exception.OrderNotFoundException;
import edu.kpi.iasa.mmsa.pizzadelivery.model.Order;
import edu.kpi.iasa.mmsa.pizzadelivery.model.User;
import edu.kpi.iasa.mmsa.pizzadelivery.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class OrderService
{
    private final OrderRepository orderRepository;
    private final EntityManager em;

    public OrderService(OrderRepository orderRepository, EntityManager em)
    {
        this.orderRepository = orderRepository;
        this.em = em;
    }

    public List<Order> getOrders ()
    {
        return orderRepository.findAll();
    }

    public Order saveOrder(Order newOrder)
    {
        return orderRepository.save(newOrder);
    }

    public Order getOrderById(Long id_order)
    {
        Optional<Order> order = orderRepository.findById(id_order);
        if (order.isPresent())
        {
            log.info("order: {}", order.get());
            return order.get();
        }
        throw new OrderNotFoundException();
    }

    public Order updateOrderById(Long id_order, Order updatedOrder)
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
        oldOrder.setComment(updatedOrder.getComment());
        oldOrder.setStatusId(updatedOrder.getStatusId());
        oldOrder.setBclosed(updatedOrder.getBclosed());
    }

    public String deleteOrderById(Long id_order)
    {
        orderRepository.deleteById(id_order);
        return "Order was successfully deleted!";
    }

}
