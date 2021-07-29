package com.learn.services;

import com.learn.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService
{

    List<User> list = new ArrayList<User>();

    public UserService()
    {
        list.add(new User("abc","abc","ABC@gmail.com"));
        list.add(new User("xyz","xyz","XYZ@gmail.com"));

    }

    //get all users
    public List<User> getAllUsers()
    {

        return list;
    }

    //get single user
    public User getUser(String username)
    {
        return this.list.stream().filter((user) ->user.getUsername().equals(username)).findAny().get();
    }

    //add new user
    public User addUser(User user)
    {
        this.list.add(user);
        return user;
    }
}
