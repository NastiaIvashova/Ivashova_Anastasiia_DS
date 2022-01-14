package com.pizzarestaurant.pizzadelivery.repository;

import com.pizzarestaurant.pizzadelivery.repository.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
