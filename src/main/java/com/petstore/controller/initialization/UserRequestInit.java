package com.petstore.controller.initialization;

import com.petstore.controller.implementation.RequestType;
import com.petstore.controller.implementation.UserRequestImpl;

public class UserRequestInit implements RequestInitialization {
    @Override
    public RequestType requestType() {
        return new UserRequestImpl();
    }
}
