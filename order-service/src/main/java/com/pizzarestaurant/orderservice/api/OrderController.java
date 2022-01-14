package com.pizzarestaurant.orderservice.api;

import com.pizzarestaurant.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController
{
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<com.pizzarestaurant.orderservice.repository.model.Order>> index()
    {
        final List<com.pizzarestaurant.orderservice.repository.model.Order> orders = orderService.fetchAll();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{idOrder}")
    public ResponseEntity<com.pizzarestaurant.orderservice.repository.model.Order> show(@PathVariable Long idOrder){
        try{
            final com.pizzarestaurant.orderservice.repository.model.Order order = orderService.fetchById(idOrder);
            return ResponseEntity.ok(order);
        }
        catch (IllegalArgumentException e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.pizzarestaurant.orderservice.api.dto.Order order)
    {
        final Long userId = order.getUserId();
        final Long pizzaId = order.getPizzaId();
        final int amountPizza = order.getAmountPizza();
        final LocalDateTime orderDate = order.getOrderDate();
        final LocalDateTime deliveryDate = order.getDeliveryDate();
        final String city = order.getCity();
        final String street = order.getStreet();
        final int number = order.getNumber();
        final int entrance = order.getEntrance();
        final String comment = order.getComment();
        final String status = order.getStatus();

        final long idOrder = orderService.create(userId, pizzaId, amountPizza, orderDate, deliveryDate, city, street, number, entrance, comment, status);
        final String location = String.format("/orders/%d", idOrder);

        return ResponseEntity.created(URI.create(location)).build();
    }

    @PatchMapping("/{idOrder}")
    public ResponseEntity<Void> update(@PathVariable Long idOrder, @RequestBody com.pizzarestaurant.orderservice.api.dto.Order order){
        final Long userId = order.getUserId();
        final Long pizzaId = order.getPizzaId();
        final int amountPizza = order.getAmountPizza();
        final LocalDateTime orderDate = order.getOrderDate();
        final LocalDateTime deliveryDate = order.getDeliveryDate();
        final String city = order.getCity();
        final String street = order.getStreet();
        final int number = order.getNumber();
        final int entrance = order.getEntrance();
        final String comment = order.getComment();
        final String status = order.getStatus();
        try
        {
            orderService.update(idOrder,userId, pizzaId, amountPizza, orderDate, deliveryDate, city, street, number, entrance, comment, status);
            return ResponseEntity.noContent().build();
        }
        catch(IllegalArgumentException e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idOrder}")
    public ResponseEntity<Void> delete(@PathVariable Long idOrder)
    {
        orderService.delete(idOrder);
        return ResponseEntity.noContent().build();
    }
}
