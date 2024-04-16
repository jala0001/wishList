package com.example.wishlist.services;

import com.example.wishlist.models.User;
import com.example.wishlist.models.Wish;
import com.example.wishlist.models.WishList;
import com.example.wishlist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.getUsers();
    }
    public List<WishList> getWishLists(int id) {
        return userRepository.getWishLists(id);
    }

    public User getUser(int id) {
        return userRepository.getUser(id);
    }

    public void addUser(String username, String userEmail, String password) {
        userRepository.addUser(username, userEmail, password);
    }



    public void addWishList(String header, int id) {
        userRepository.addWishList(header, id);
    }

    public void deleteUser(int wishlistId) {
        userRepository.deleteUser(wishlistId);
    }


    public WishList getWishList(int wishlistId) {
        return userRepository.getWishList(wishlistId);
    }

    public List<Wish> getWishes(int wishlistId) {
        return userRepository.getWishes(wishlistId);
    }

    public void deleteWish(int wishId) {
        userRepository.deleteWish(wishId);
    }

    public void addWish(String header, String link, double price, String note, int wishlistId) {
        userRepository.addWish(header, link, price, note, wishlistId);
    }


}

