package edu.kpi.iasa.mmsa.pizzadelivery.controller;

import edu.kpi.iasa.mmsa.pizzadelivery.model.User;
import edu.kpi.iasa.mmsa.pizzadelivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController
{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public ResponseEntity<List<User>> getUsers()
    {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping(value = "/user")
    public ResponseEntity<User> postUsers(@Valid @RequestBody User newUser)
    {
        return ResponseEntity.ok(userService.saveUsers(newUser));
    }

    @GetMapping(value = "/user/{id_user}")
    public ResponseEntity<User> getUser(@PathVariable Long id_user)
    {
        return ResponseEntity.ok(userService.getUserById(id_user));
    }

    @PutMapping(value = "/user/{id_user}")
    public ResponseEntity<User> updateUser(@PathVariable Long id_user, @Valid @RequestBody User updatedUser)
    {
        return ResponseEntity.ok(userService.updateUserById(id_user, updatedUser));
    }

    @DeleteMapping(value = "/user/{id_user}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id_user)
    {
        return ResponseEntity.ok(userService.deleteUserById(id_user));
    }

}
