package com.example.wishlist.models;

public class SharedWishList {
    private int userId;
    private int sharedWishlists;

    public SharedWishList(){

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSharedWishlists() {
        return sharedWishlists;
    }

    public void setSharedWishlists(int sharedWishlists) {
        this.sharedWishlists = sharedWishlists;
    }
}
