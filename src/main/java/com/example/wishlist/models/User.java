package com.example.wishlist.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String username;
    private String userEmail;
    private String password;
    private int sharedWishLists;

    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSharedWishLists() {
        return sharedWishLists;
    }

    public void setSharedWishLists(int sharedWishLists) {
        this.sharedWishLists = sharedWishLists;
    }
}
