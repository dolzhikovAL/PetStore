package com.petstore.controller.services;

import java.util.Arrays;
import java.util.Optional;

public enum EntityType {
    PET("pet"),ORDER("order"),USER("user");

    private String type;

    public String getType() {
        return type;
    }

    EntityType(String type) {
        this.type = type;
    }
    public static Optional<EntityType> getType(String type){
        return Arrays.stream(EntityType.values())
                .filter(enumValue->enumValue.getType().equals(type))
                .findAny();
    }
}
