package edu.kpi.iasa.mmsa.pizzadelivery.repository;

import edu.kpi.iasa.mmsa.pizzadelivery.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>
{

}
