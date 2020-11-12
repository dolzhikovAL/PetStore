package com.petstore.controller.initialization;

import com.petstore.controller.implementation.PetRequestImpl;
import com.petstore.controller.implementation.RequestType;

public class PetRequestInit implements RequestInitialization{

    @Override
    public RequestType requestType() {
        return new PetRequestImpl<>();
    }
}
