package edu.kpi.iasa.mmsa.pizzadelivery.repository;

import edu.kpi.iasa.mmsa.pizzadelivery.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long>
{

}
