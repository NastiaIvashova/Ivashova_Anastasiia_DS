package com.pizzarestaurant.pizzadelivery.api;

import com.pizzarestaurant.pizzadelivery.model.Pizza;
import com.pizzarestaurant.pizzadelivery.service.PizzaService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PizzaController
{
    private final PizzaService pizzaService;

    private final RestTemplate restTemplate;

    @RequestMapping(value="/")
    public String order() throws JsonParseException
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "I am pizza service");
        return jsonObject.toString();
    }

    @Autowired
    public PizzaController(PizzaService pizzaService, RestTemplate restTemplate)
    {
        this.pizzaService = pizzaService;
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/pizza")
    public ResponseEntity<List<Pizza>> getPizzas()
    {
        return ResponseEntity.ok(pizzaService.getPizzas());
    }

    @PostMapping(value = "/pizza")
    public ResponseEntity<Pizza> postPizzas(@Valid @RequestBody Pizza newPizza)
    {
        return ResponseEntity.ok(pizzaService.savePizza(newPizza));
    }

    @GetMapping(value = "/pizza/{id_pizza}")
    public ResponseEntity<Pizza> getPizza(@PathVariable Long id_pizza)
    {
        try
        {
            return ResponseEntity.ok(pizzaService.getPizzaById(id_pizza));
        }
        catch(IllegalArgumentException e)
        {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping(value = "/pizza/{id_pizza}")
    public ResponseEntity<Pizza> updatePizza(@PathVariable Long id_pizza, @Valid @RequestBody Pizza updatedPizza)
    {
        try
        {
            return ResponseEntity.ok(pizzaService.updatePizzaById(id_pizza, updatedPizza));
        }
        catch(IllegalArgumentException e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/pizza/{id_pizza}")
    public ResponseEntity<String> deletePizza(@PathVariable Long id_pizza)
    {
        return ResponseEntity.ok(pizzaService.deletePizzaById(id_pizza));
    }
}
