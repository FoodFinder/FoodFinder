package com.bcpratt.foodfinder.model;

public class MenuItem {

    private String name;
    private double price;
    private double rating; // 0 to 1
    boolean isVegitarian;

    public MenuItem(String name, double price, int rating, boolean isVegitarian){
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.isVegitarian = isVegitarian;
    }



    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    public double getRating() {
        return rating;
    }

    public boolean isVegitarian() {
        return isVegitarian;
    }

}
