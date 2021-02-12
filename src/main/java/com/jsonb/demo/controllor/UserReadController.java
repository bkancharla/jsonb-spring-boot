package com.jsonb.demo.controllor;

import com.jsonb.demo.entity.Users;
import com.jsonb.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserReadController {
    private final UserService userService;

    public UserReadController(UserService userService) {
        this.userService = userService;
    }

    /**
     * This will read the data which has given Salary
     * http://localhost:8080/read/200000.0
     *
     * @return
     */
    @GetMapping("/read/{salary}")
    public List<Users> readySalaryContains(@PathVariable double salary) {

        return userService.readSalaryContains(salary);
    }
}

