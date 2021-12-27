package com.pizzarestaurant.pizzadelivery.service;

import com.pizzarestaurant.pizzadelivery.exception.PizzaNotFoundException;
import com.pizzarestaurant.pizzadelivery.model.Pizza;
import com.pizzarestaurant.pizzadelivery.repository.PizzaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PizzaService extends RuntimeException
{
    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository)
    {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> getPizzas()
    {
        return pizzaRepository.findAll();
    }

    public Pizza savePizza(Pizza newPizza)
    {
        return pizzaRepository.save(newPizza);
    }

    public Pizza getPizzaById(Long id_pizza) throws IllegalArgumentException
    {
        Optional<Pizza> pizza = pizzaRepository.findById(id_pizza);
        if (pizza.isPresent())
        {
            log.info("pizza: {}", pizza.get());
            return pizza.get();
        }
        throw new PizzaNotFoundException();
    }

    public Pizza updatePizzaById(Long id_pizza, Pizza updatedPizza) throws IllegalArgumentException
    {
        Optional<Pizza> pizza = pizzaRepository.findById(id_pizza);
        if (pizza.isPresent()) {
            Pizza oldPizza = pizza.get();
            log.info("pizza: {}", oldPizza);
            updatePizza(oldPizza, updatedPizza);
            return pizzaRepository.save(oldPizza);
        }
        throw new PizzaNotFoundException();
    }

    private void updatePizza(Pizza oldPizza, Pizza updatedPizza)
    {
        oldPizza.setName(updatedPizza.getName());
        oldPizza.setSize(updatedPizza.getSize());
        oldPizza.setPrice(updatedPizza.getPrice());
        oldPizza.setDescription(updatedPizza.getDescription());
        oldPizza.setTime(updatedPizza.getTime());
        oldPizza.setBonus(updatedPizza.getBonus());
        oldPizza.setDiscounts(updatedPizza.getDiscounts());
    }

    public String deletePizzaById(Long id_pizza)
    {
        pizzaRepository.deleteById(id_pizza);
        return "Pizza was successfully deleted!";
    }

}
