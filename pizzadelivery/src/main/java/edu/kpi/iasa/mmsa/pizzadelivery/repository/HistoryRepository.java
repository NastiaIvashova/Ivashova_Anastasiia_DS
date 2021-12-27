package edu.kpi.iasa.mmsa.pizzadelivery.repository;

import edu.kpi.iasa.mmsa.pizzadelivery.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long>
{
}
