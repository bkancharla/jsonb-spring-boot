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

    /**
     * This will Create new jsonb field
     */
    @GetMapping("/create/{firstName}")
    public void createNewUser(@PathVariable String firstName) {
        userService.createNewUserWithJsonb(firstName);
    }

    /**
     * This will update specific part of jsonb
     */
    @GetMapping("/updateaddress/{id}")
    public void updateSpecificUserSalary(@PathVariable int id) {
        userService.updateUserSalary(id);
    }
}

