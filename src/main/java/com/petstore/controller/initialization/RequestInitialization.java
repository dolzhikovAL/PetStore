package com.petstore.controller.initialization;

import com.petstore.controller.implementation.RequestType;

import java.net.Authenticator;

public interface RequestInitialization {
   RequestType requestType();
}
