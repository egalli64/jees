/*
 * Introduction to Jakarta Enterprise Edition - Servlet & JSP
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.m2.s8.npb;

/**
 * A simple JavaBean
 */
public class Album {
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
