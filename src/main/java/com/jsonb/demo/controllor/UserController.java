package com.jsonb.demo.controllor;


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

    /**
     * This will add to  existing array (prepend the data)

     */
    @GetMapping("/updatechilds/{id}")
    public void addToArray(@PathVariable int id) {
        userService.addToArray(id);
    }

    /**
     * This will Remove specific element from existing array
     */
    @GetMapping("/removearray/{id}")
    public void removeFromArray(@PathVariable int id) {
        userService.removeFromChildArray(id);
    }
}

