package com.learn.contorllers;


import com.learn.models.User;
import com.learn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService userService;

    //all user
    @GetMapping("/")
    public List<User> getAllUsers()
    {
        return this.userService.getAllUsers();
    }

    //single user
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username)
    {
        return this.userService.getUser(username);
    }

    //add user
    @PostMapping("/add")
    public User addUser(@RequestBody User user)
    {
        return this.userService.addUser(user);

    }
}
