package com.example.wishlist.models;

public class WishList {
    private int wishListId;
    private int userId;
    private String wishListHeader;

    public WishList() {
    }

    public int getWishListId() {
        return wishListId;
    }

    public void setWishListId(int wishListId) {
        this.wishListId = wishListId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getWishListHeader() {
        return wishListHeader;
    }

    public void setWishListHeader(String wishListHeader) {
        this.wishListHeader = wishListHeader;
    }
}
