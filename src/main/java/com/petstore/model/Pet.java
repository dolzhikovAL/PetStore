package com.petstore.model;

public class Pet implements EntityPath {
    private long id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tag[] tags;
    private PetStatus status;

    public Pet() {
    }

    public Pet(long id,  String name ,Category category, String[] photoUrls, Tag[] tags, PetStatus status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    @Override
    public String getPath() {
        return "/v2/pet";
    }

    @Override
    public String toString() {
        return "Order  id -- " + getId() + ", category -- " +getCategory() + ", name -- " + getName() +
                ", photoUrls -- " + getPhotoUrls().toString()+ ", tags -- " +getTags().toString()+ ", status --" + getStatus();
    }


    public long getId() {
        return id;
    }


    public Category getCategory() {
        return category;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }


    public Tag[] getTags() {
        return tags;
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
    }

    public PetStatus getStatus() {
        return status;
    }



}
