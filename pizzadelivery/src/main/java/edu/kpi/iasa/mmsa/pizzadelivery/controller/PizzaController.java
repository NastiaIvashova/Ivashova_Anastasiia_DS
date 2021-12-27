package edu.kpi.iasa.mmsa.pizzadelivery.controller;

import edu.kpi.iasa.mmsa.pizzadelivery.model.Pizza;
import edu.kpi.iasa.mmsa.pizzadelivery.model.User;
import edu.kpi.iasa.mmsa.pizzadelivery.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PizzaController
{
    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService)
    {
        this.pizzaService = pizzaService;
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
        return ResponseEntity.ok(pizzaService.getPizzaById(id_pizza));
    }

    @PutMapping(value = "/pizza/{id_pizza}")
    public ResponseEntity<Pizza> updatePizza(@PathVariable Long id_pizza, @Valid @RequestBody Pizza updatedPizza)
    {
        return ResponseEntity.ok(pizzaService.updatePizzaById(id_pizza, updatedPizza));
    }

    @DeleteMapping(value = "/pizza/{id_pizza}")
    public ResponseEntity<String> deletePizza(@PathVariable Long id_pizza)
    {
        return ResponseEntity.ok(pizzaService.deletePizzaById(id_pizza));
    }

    @GetMapping(value = "/FindPizza/{name}")
    public ResponseEntity<List<Pizza>> findByPizzaName(@PathVariable String name)
    {
        return ResponseEntity.ok(pizzaService.getPizzaByName(name));
    }

}
