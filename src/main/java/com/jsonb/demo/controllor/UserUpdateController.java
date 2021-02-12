package com.jsonb.demo.controllor;


import com.jsonb.demo.entity.Users;
import com.jsonb.demo.model.PersonalDetails;
import com.jsonb.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class UserUpdateController {
    private final UserService userService;

    public UserUpdateController(UserService userService) {
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
     * User provides all the data
     * curl -X PUT -H "Content-Type: application/json" -d '{"salary": 100000.0, "address": {"city": "columbus", "state": "ohio", "country": "usa"},
     * "children": ["lory", "jack"], "phoneNumber": "333-333-0000"}' http://localhost:8080/createwithalldetails
     *
     * @return
     */
    @PutMapping("/createwithalldetails")
    public Users createUser(@RequestBody PersonalDetails personalDetails) {
        return userService.createNewUserWithAllDetails(personalDetails);
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

