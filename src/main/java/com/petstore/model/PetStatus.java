package com.petstore.model;

import java.util.Arrays;
import java.util.Optional;

public enum PetStatus {
    AVAILABLE("available"),PENDING("pending"),SOLD("sold");

    private String status;

    PetStatus(String status) {
        this.status = status;
    }

    public static Optional<PetStatus> getPetStatus(String status){
        return Arrays.stream(PetStatus.values())
                .filter(enumValue->enumValue.getStatus().equals(status))
                .findAny();
    }



    public String getStatus() {
        return status;
    }
}
