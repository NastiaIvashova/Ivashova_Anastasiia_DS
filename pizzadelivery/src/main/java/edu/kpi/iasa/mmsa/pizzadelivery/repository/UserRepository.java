package edu.kpi.iasa.mmsa.pizzadelivery.repository;

import edu.kpi.iasa.mmsa.pizzadelivery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
}
