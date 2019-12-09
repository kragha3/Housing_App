package com.example.myapplication;

public class Apartment {
    private String name;
    private int price;
    private int bedrooms;
    private int bathrooms;
    private String location;
    Apartment(String setName, int setPrice, int setRooms, int setBathrooms, String setLocation) {
        name = setName;
        price = setPrice;
        bedrooms = setRooms;
        bathrooms = setBathrooms;
        location = setLocation;
    }
    public int getPrice() {
        return price;
    }
    public int getBedrooms() {
        return bedrooms;
    }
    public int getBathrooms() {
        return bathrooms;
    }
    public String getLocation() {
        return location;
    }
}
