package com.djs.springboot.controller;

import com.djs.springboot.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/{id}")
    public User getUser(@PathVariable("id")String id){
        return new User(id,"djs","22");

    }
}
