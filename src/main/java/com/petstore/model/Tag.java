package com.petstore.model;

public class Tag {

    private int id;
    private String name;


    public Tag(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Tag -- id = " + getId() + ", name -- " + getName();
    }
}
