package com.pizzarestaurant.pizzadelivery.api;

import com.pizzarestaurant.pizzadelivery.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pizza")
public class PizzaController
{
    private final PizzaService pizzaService;

    @GetMapping
    public ResponseEntity<List<com.pizzarestaurant.pizzadelivery.repository.model.Pizza>> index()
    {
        final List<com.pizzarestaurant.pizzadelivery.repository.model.Pizza> pizzas = pizzaService.fetchAll();
        return ResponseEntity.ok(pizzas);
    }

    @GetMapping("/{id_pizza}")
    public ResponseEntity<com.pizzarestaurant.pizzadelivery.repository.model.Pizza> show(@PathVariable Long id_pizza)
    {
        try
        {
            final com.pizzarestaurant.pizzadelivery.repository.model.Pizza pizza = pizzaService.fetchById(id_pizza);
            return ResponseEntity.ok(pizza);
        }
        catch (IllegalArgumentException e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.pizzarestaurant.pizzadelivery.api.dto.Pizza pizza){

        final String name = pizza.getName();
        final int size = pizza.getSize();
        final BigDecimal price = pizza.getPrice();
        final String description = pizza.getDescription();
        final int time = pizza.getTime();
        final BigDecimal bonus = pizza.getBonus();
        final BigDecimal discounts = pizza.getDiscounts();

        final long id_pizza = pizzaService.create(name, size, price, description, time, bonus, discounts);
        final String location = String.format("/pizzas/%d", id_pizza);

        return ResponseEntity.created(URI.create(location)).build();
    }

    @PatchMapping("/{id_pizza}")
    public ResponseEntity<Void> update(@PathVariable Long id_pizza, @RequestBody com.pizzarestaurant.pizzadelivery.api.dto.Pizza pizza){
        final String name = pizza.getName();
        final int size = pizza.getSize();
        final BigDecimal price = pizza.getPrice();
        final String description = pizza.getDescription();
        final int time = pizza.getTime();
        final BigDecimal bonus = pizza.getBonus();
        final BigDecimal discounts = pizza.getDiscounts();
        try
        {
            pizzaService.update(id_pizza,name, size, price, description, time, bonus, discounts);
            return ResponseEntity.noContent().build();
        }
        catch(IllegalArgumentException e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id_pizza}")
    public ResponseEntity<Void> delete(@PathVariable Long id_pizza)
    {
        pizzaService.delete(id_pizza);
        return ResponseEntity.noContent().build();
    }
}
