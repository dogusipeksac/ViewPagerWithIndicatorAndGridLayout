package com.example.viewpagerwithindicators;

public class GridItems {
    public int id;
    public String title;

    public GridItems(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public GridItems() {
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
}
