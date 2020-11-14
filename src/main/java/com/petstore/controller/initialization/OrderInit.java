package com.petstore.controller.initialization;

import com.petstore.controller.implementation.OrderRequestImpl;
import com.petstore.controller.implementation.RequestType;

public class OrderInit implements RequestInitialization {


    @Override
    public RequestType requestType() {
        return new OrderRequestImpl();
    }
}
