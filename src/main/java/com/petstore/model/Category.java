package com.petstore.model;

public class Category {
    private long id;
    private String name;


    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return "Category -- id = " + getId() + ", name -- " + getName();
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

}
