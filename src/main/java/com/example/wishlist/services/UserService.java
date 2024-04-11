package com.example.wishlist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private com.example.wishlist.repositories.UserRepository userRepository;

    public List<com.example.wishlist.models.User> getUsers() {
        return userRepository.getUsers();
    }

    public com.example.wishlist.models.User getUser(int id) {
        return userRepository.getUser(id);
    }

    public void addUser(String username, String userEmail, String password) {
        userRepository.addUser(username, userEmail, password);
    }

}
