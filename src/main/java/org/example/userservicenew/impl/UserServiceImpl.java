package org.example.userservicenew.impl;

import org.example.userservicenew.entites.User;
import org.example.userservicenew.repositories.UserRepository;
import org.example.userservicenew.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository getUserRepository;

    @Override
    public User saveUser(User user) {
        String randomId= UUID.randomUUID().toString();
        user.setUserId(randomId);
        return getUserRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return getUserRepository.findAll();
    }

    @Override
    public User getUserById(String id) {
        return getUserRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUserbyId(String id) {
        return getUserRepository.findById(id).orElse(null);
    }
}
