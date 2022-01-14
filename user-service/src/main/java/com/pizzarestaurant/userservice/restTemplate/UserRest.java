package com.pizzarestaurant.userservice.restTemplate;

import com.pizzarestaurant.userservice.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserRest
{
    private final UserService userService;

    private final RestTemplate restTemplate;

    @Autowired
    public UserRest(UserService userService, RestTemplate restTemplate)
    {
        this.userService = userService;
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value="/messageUser")
    public String user() throws JsonParseException
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "Hello, i am user service");
        return jsonObject.toString();
    }

}
