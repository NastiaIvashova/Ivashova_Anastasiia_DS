package com.pizzarestaurant.userservice.api;

import com.pizzarestaurant.userservice.model.User;
import com.pizzarestaurant.userservice.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;


@RestController
public class UserController
{
    private final UserService userService;

    private final RestTemplate restTemplate;

    @RequestMapping(value="/")
    public String order() throws JsonParseException
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "I am user service");
        return jsonObject.toString();
    }

    @Autowired
    public UserController(UserService userService, RestTemplate restTemplate)
    {
        this.userService = userService;
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/user")
    public ResponseEntity<List<User>> index()
    {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("user/{id_user}")
    public ResponseEntity<User> show(@PathVariable Long id_user)
    {
        try
        {
            return ResponseEntity.ok(userService.getUserById(id_user));
        }
        catch(IllegalArgumentException e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/user")
    public ResponseEntity<User> create(@Valid @RequestBody User newUser)
    {
        return ResponseEntity.ok(userService.saveUser(newUser));
    }

    @PutMapping("/user/{id_user}")
    public ResponseEntity<User> update(@PathVariable Long id_user, @Valid @RequestBody User updatedUser)
    {
        try
        {
            return ResponseEntity.ok(userService.updateUserById(id_user, updatedUser));
        }
        catch(IllegalArgumentException e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/user/{id_user}")
    public ResponseEntity<String> delete(@PathVariable Long id_user)
    {
        return ResponseEntity.ok(userService.deleteUserById(id_user));
    }
}
