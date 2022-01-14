package com.pizzarestaurant.userservice.repository;

import com.pizzarestaurant.userservice.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
}
