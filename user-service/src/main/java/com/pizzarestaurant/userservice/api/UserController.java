package com.pizzarestaurant.userservice.api;

import com.pizzarestaurant.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController
{
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<com.pizzarestaurant.userservice.repository.model.User>> index()
    {
        final List<com.pizzarestaurant.userservice.repository.model.User> users = userService.fetchAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id_user}")
    public ResponseEntity<com.pizzarestaurant.userservice.repository.model.User> show(@PathVariable Long id_user){
        try{
            final com.pizzarestaurant.userservice.repository.model.User user = userService.fetchById(id_user);
            return ResponseEntity.ok(user);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.pizzarestaurant.userservice.api.dto.User user){

        final String userType = user.getUserType();
        final String login = user.getLogin();
        final String password = user.getPassword();
        final String firstName = user.getFirstName();
        final String lastName = user.getLastName();
        final String email = user.getEmail();
        final String phone = user.getPhone();

        final long id_user = userService.create(userType, login, password, firstName,lastName,email,phone);
        final String location = String.format("/users/%d", id_user);

        return ResponseEntity.created(URI.create(location)).build();
    }

    @PatchMapping("/{id_user}")
    public ResponseEntity<Void> update(@PathVariable Long id_user, @RequestBody com.pizzarestaurant.userservice.api.dto.User user){
        final String userType = user.getUserType();
        final String login = user.getLogin();
        final String password = user.getPassword();
        final String firstName = user.getFirstName();
        final String lastName = user.getLastName();
        final String email = user.getEmail();
        final String phone = user.getPhone();
        try
        {
            userService.update(id_user,userType, login, password, firstName,lastName,email,phone);
            return ResponseEntity.noContent().build();
        }
        catch(IllegalArgumentException e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id_user}")
    public ResponseEntity<Void> delete(@PathVariable Long id_user)
    {
        userService.delete(id_user);
        return ResponseEntity.noContent().build();
    }
}
