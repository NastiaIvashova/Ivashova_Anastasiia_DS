package com.pizzarestaurant.orderservice.restTemplate;

import com.pizzarestaurant.orderservice.service.OrderService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderRest
{
    private final OrderService orderService;

    private final RestTemplate restTemplate;

    @Autowired
    public OrderRest(OrderService orderService, RestTemplate restTemplate)
    {
        this.orderService = orderService;
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/connection")
    public String order() throws JsonParseException
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message-1", "I am order service");
        jsonObject.put("message-2", restTemplate.exchange("http://localhost:8081/user/messageUser", HttpMethod.GET, null, String.class).getBody());
        jsonObject.put("message-3", restTemplate.exchange("http://localhost:8084/pizza/messagePizza", HttpMethod.GET, null, String.class).getBody());
        return jsonObject.toString();
    }
}
