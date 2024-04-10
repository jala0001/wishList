package com.example.wishlist.models;

public class Wish {
    private int wishId;
    private int userId;
    private String wishHeader;
    private String wishLink;
    private double wishPrice;
    private String wishNote;

    public Wish() {

    }

    public int getWishId() {
        return wishId;
    }

    public void setWishId(int wishId) {
        this.wishId = wishId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getWishHeader() {
        return wishHeader;
    }

    public void setWishHeader(String wishHeader) {
        this.wishHeader = wishHeader;
    }

    public String getWishLink() {
        return wishLink;
    }

    public void setWishLink(String wishLink) {
        this.wishLink = wishLink;
    }

    public double getWishPrice() {
        return wishPrice;
    }

    public void setWishPrice(double wishPrice) {
        this.wishPrice = wishPrice;
    }

    public String getWishNote() {
        return wishNote;
    }

    public void setWishNote(String wishNote) {
        this.wishNote = wishNote;
    }
}
