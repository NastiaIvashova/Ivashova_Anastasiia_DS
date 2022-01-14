package com.pizzarestaurant.pizzadelivery.service;

import com.pizzarestaurant.pizzadelivery.repository.model.Pizza;
import com.pizzarestaurant.pizzadelivery.repository.PizzaRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PizzaService
{
    private final PizzaRepository pizzaRepository;

    public List<Pizza> fetchAll(){
        return pizzaRepository.findAll();
    }

    public Pizza fetchById(Long id_pizza) throws IllegalArgumentException
    {
        final Optional<Pizza> maybePizza = pizzaRepository.findById(id_pizza);

        if (maybePizza.isEmpty()) throw new IllegalArgumentException("Pizza is not found");
        else return maybePizza.get();
    }

    public long create(String name, int size, BigDecimal price, String description, int time, BigDecimal bonus, BigDecimal discounts)
    {
        final Pizza pizza = new Pizza(name, size, price, description, time, bonus, discounts);
        final Pizza savedPizza = pizzaRepository.save(pizza);

        return savedPizza.getId_pizza();
    }

    public void update(Long id_pizza, String name, int size, BigDecimal price, String description, int time, BigDecimal bonus, BigDecimal discounts) throws IllegalArgumentException
    {
        final Optional<Pizza> maybePizza = pizzaRepository.findById(id_pizza);
        if (maybePizza.isEmpty()) throw new IllegalArgumentException("Pizza is not found");

        final Pizza pizza = maybePizza.get();
        if(name != null && !name.isBlank()) pizza.setName(name);
        if(size != 0) pizza.setSize(size);
        if(price != null) pizza.setPrice(price);
        if(description != null && !description.isBlank()) pizza.setDescription(description);
        if(time != 0) pizza.setTime(time);
        if(bonus != null) pizza.setBonus(bonus);
        if(discounts != null) pizza.setDiscounts(discounts);
        pizzaRepository.save(pizza);
    }

    public void delete(Long id_pizza)
    {
        pizzaRepository.deleteById(id_pizza);
    }
}
