package com.petstore.model;

import com.google.api.client.util.DateTime;

public class Order implements EntityPath {
    private long id;
    private long petId;
    private int quantity;
    private DateTime shipDate;
    private OrderStatus status;
    private boolean complete = false;

    public Order() {
    }

    public Order(long id, long petId, int quantity, DateTime shipDate, OrderStatus status, boolean complete) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }

    public long getId() {
        return id;
    }


    public long getPetId() {
        return petId;
    }


    public int getQuantity() {
        return quantity;
    }

    public DateTime getShipDate() {
        return shipDate;
    }


    public OrderStatus getStatus() {
        return status;
    }


    public boolean isComplete() {
        return complete;
    }



    @Override
    public String toString() {
        return "Order  id -- " + getId() + ", petID -- " + getPetId() + ", quantity -- " + getQuantity() + ", shipDate -- " + getShipDate() +
                "status -- " + getStatus() + ", complete --" + isComplete();
    }

    @Override
    public String getPath() {
        return "/v2/store/order";
    }

    public String getStorePath(){
        return "/v2/store";
    }

}