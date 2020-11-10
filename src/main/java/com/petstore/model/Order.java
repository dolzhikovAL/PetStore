package com.petstore.model;

import com.google.api.client.util.DateTime;

public class Order {
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

    public void setId(long id) {
        this.id = id;
    }

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public DateTime getShipDate() {
        return shipDate;
    }

    public void setShipDate(DateTime shipDate) {
        this.shipDate = shipDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
            return "Order  id -- " + getId() + ", petID -- " +getPetId() + ", quantity -- " + getQuantity() + ", shipDate -- " + getShipDate() +
                    "status -- " +getStatus()+ ", complete --" + isComplete();

    }
}
