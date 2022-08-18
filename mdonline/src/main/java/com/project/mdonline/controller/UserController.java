package com.project.mdonline.controller;

import com.project.mdonline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String checkWorking(){
        return "App is working...";
    }

    @GetMapping(path="/allusers")
    public List<String> getAllUserNames(){
        return userRepository.getAllUserNames();
    }
}
