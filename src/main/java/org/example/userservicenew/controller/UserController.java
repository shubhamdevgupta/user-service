package org.example.userservicenew.controller;

import org.example.userservicenew.entites.User;
import org.example.userservicenew.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/saveuser")
    ResponseEntity<User> createUser(@RequestBody User user) {
      User user1=  userService.saveUser(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{userId}")
    ResponseEntity<User> getUserById(@PathVariable  String userId) {
      User user1=  userService.getUserById(userId);
        return  ResponseEntity.status(HttpStatus.OK).body(user1);
    }

    @GetMapping("/getAllUsers")
    ResponseEntity<List<User>> getAllUsers() {
      List<User> userList=  userService.getAllUsers();
        return  ResponseEntity.status(HttpStatus.OK).body(userList);
    }


}
