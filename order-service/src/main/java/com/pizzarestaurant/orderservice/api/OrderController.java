package com.pizzarestaurant.orderservice.api;

import com.pizzarestaurant.orderservice.model.Order;
import com.pizzarestaurant.orderservice.service.OrderService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderController
{
    private final OrderService orderService;

    private final RestTemplate restTemplate;

    @RequestMapping("/")
    public String order() throws JsonParseException
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "I am order service");
        jsonObject.put("message-2", restTemplate.exchange("http://localhost:8081/", HttpMethod.GET, null, String.class).getBody());
        jsonObject.put("message-3", restTemplate.exchange("http://localhost:8082/", HttpMethod.GET, null, String.class).getBody());
        return jsonObject.toString();
    }

    @Autowired
    public OrderController(OrderService orderService, RestTemplate restTemplate)
    {
        this.orderService = orderService;
        this.restTemplate = restTemplate;
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

    @GetMapping("/order/{id_order}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id_order)
    {
        try
        {
            return ResponseEntity.ok(orderService.getOrderById(id_order));
        }
        catch(IllegalArgumentException e)
        {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/order/{id_order}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id_order, @Valid @RequestBody Order updatedOrder)
    {
        try
        {
            return ResponseEntity.ok(orderService.updateOrderById(id_order, updatedOrder));
        }
        catch(IllegalArgumentException e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("order/{id_order}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id_order)
    {
        return ResponseEntity.ok(orderService.deleteOrderById(id_order));
    }
}
