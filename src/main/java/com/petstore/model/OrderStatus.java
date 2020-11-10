package com.petstore.model;

import java.util.Arrays;
import java.util.Optional;

public enum OrderStatus {

    PLACED("placed"),APPROVED("approved"),DELIVERED("delivered");
    private String status;

    public static Optional<OrderStatus> getOrderStatus(String status){
        return Arrays.stream(OrderStatus.values())
                .filter(enumValue->enumValue.getStatus().equals(status))
                .findAny();
    }

    public String getStatus() {
        return status;
    }

    OrderStatus(String status) {
        this.status=status;
    }
}
