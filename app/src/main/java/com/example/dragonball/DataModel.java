package com.example.dragonball;

public class DataModel {

    String name;
    String shortDescription;
    int image;
    int id;

    public DataModel(String name, String shortDescription, int image, int id) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.image=image;
        this.id=id;
    }


    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public int getImage() {
        return image;
    }

    public int getId() {return id;}
}