package com.pizzarestaurant.userservice.service;

import com.pizzarestaurant.userservice.repository.model.User;
import com.pizzarestaurant.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService
{
    private final UserRepository userRepository;

    public List<User> fetchAll(){
        return userRepository.findAll();
    }

    public User fetchById(Long id_user) throws IllegalArgumentException
    {
        final Optional<User> maybeUser = userRepository.findById(id_user);

        if (maybeUser.isEmpty()) throw new IllegalArgumentException("User is not found");
        else return maybeUser.get();
    }

    public long create(String userType, String login, String password, String firstName, String lastName, String email, String phone)
    {
        final User user = new User(userType, login, password, firstName,lastName,email,phone);
        final User savedUser = userRepository.save(user);

        return savedUser.getId_user();
    }

    public void update(Long id_user, String userType, String login, String password, String firstName, String lastName, String email, String phone) throws IllegalArgumentException
    {
        final Optional<User> maybeUser = userRepository.findById(id_user);
        if (maybeUser.isEmpty()) throw new IllegalArgumentException("User is not found");

        final User user = maybeUser.get();
        if(userType != null && !userType.isBlank()) user.setUserType(userType);
        if(login != null && !login.isBlank()) user.setLogin(login);
        if(password != null && !password.isBlank()) user.setPassword(password);
        if(firstName != null && !firstName.isBlank())user.setFirstName(firstName);
        if(lastName != null && !lastName.isBlank())user.setLastName(lastName);
        if(email != null && !email.isBlank()) user.setEmail(email);
        if(phone != null && !phone.isBlank()) user.setPhone(phone);

        userRepository.save(user);
    }

    public void delete(Long id_user)
    {
        userRepository.deleteById(id_user);
    }
}
