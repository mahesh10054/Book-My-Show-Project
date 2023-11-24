package com.example.BookMyShow.Controller;

import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.RequestDTOs.AddUserRequest;
import com.example.BookMyShow.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody AddUserRequest addUserRequest)
    {
        return userService.addUser(addUserRequest);
    }
}
