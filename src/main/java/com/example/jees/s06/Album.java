package com.example.jees.s06;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Album implements Serializable {
    private int id;
    private String title;
    private int quantity;

    public Album() {
    }

    public Album(int id, String title, int quantity) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Album [id=" + id + ", title=" + title + ", quantity=" + quantity + "]";
    }
}
