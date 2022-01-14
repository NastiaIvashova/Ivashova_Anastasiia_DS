package com.pizzarestaurant.pizzadelivery.restTemplate;

import com.pizzarestaurant.pizzadelivery.service.PizzaService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/pizza")
public class PizzaRest
{
    private final PizzaService pizzaService;

    private final RestTemplate restTemplate;

    @Autowired
    public PizzaRest(PizzaService pizzaService, RestTemplate restTemplate)
    {
        this.pizzaService = pizzaService;
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value="/messagePizza")
    public String user() throws JsonParseException
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "Hello, i am pizza service");
        return jsonObject.toString();
    }
}

