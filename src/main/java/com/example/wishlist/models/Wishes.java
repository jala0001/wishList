package com.example.wishlist.models;

public class Wishes {
    public Wishes(String title, String link, String note) {
        this.title = title;
        this.link = link;
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    private String title;
    private String link;
    private String note;

}
