package com.jsonb.demo.controllor;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.jsonb.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create/{firstName}")
    public void  create(@PathVariable String firstName) {
        userService.create(firstName);
    }
    @GetMapping("/updateaddress/{id}")
    public void  updateUsers(@PathVariable int id) {
        userService.update(id);
    }
}

