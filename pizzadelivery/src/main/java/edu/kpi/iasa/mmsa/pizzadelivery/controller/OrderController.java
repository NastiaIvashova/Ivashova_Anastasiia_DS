package edu.kpi.iasa.mmsa.pizzadelivery.controller;

import edu.kpi.iasa.mmsa.pizzadelivery.model.Order;
import edu.kpi.iasa.mmsa.pizzadelivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OrderController
{
    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService)
    {
        this.orderService = orderService;
    }

    @GetMapping(value = "/order")
    public ResponseEntity<List<Order>> getOrders()
    {
        return ResponseEntity.ok(orderService.getOrders());
    }

    @PostMapping(value = "/order")
    public ResponseEntity<Order> postOrders(@Valid @RequestBody Order newOrder)
    {
        return ResponseEntity.ok(orderService.saveOrder(newOrder));
    }

    @GetMapping(value = "/order/{id_order}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id_order)
    {
        return ResponseEntity.ok(orderService.getOrderById(id_order));
    }

    @PutMapping(value = "/order/{id_order}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id_order, @Valid @RequestBody Order updatedOrder)
    {
        return ResponseEntity.ok(orderService.updateOrderById(id_order, updatedOrder));
    }

    @DeleteMapping(value = "/order/{id_order}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id_order)
    {
        return ResponseEntity.ok(orderService.deleteOrderById(id_order));
    }

}
