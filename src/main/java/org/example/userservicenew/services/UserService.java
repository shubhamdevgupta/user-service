package org.example.userservicenew.services;

import org.example.userservicenew.entites.User;

import java.util.List;

public interface UserService {


    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(String id);

    User updateUserbyId(String id);
}
