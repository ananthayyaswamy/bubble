package com.bubble.bubble.controller;

import com.bubble.bubble.entity.User;
import com.bubble.bubble.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/user/")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }
    @PostMapping("login/")
    public ResponseEntity<User> loginUser(@RequestBody User user){
        User user1 =userService.loginUser(user);
        if(user1!=null){
            return  new ResponseEntity<>(user1,HttpStatus.OK);
        }
        return  new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
    }
}
