package com.pizzarestaurant.orderservice.repository;

import com.pizzarestaurant.orderservice.repository.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>
{

}
