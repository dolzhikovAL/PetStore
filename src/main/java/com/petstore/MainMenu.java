package com.petstore;

import com.petstore.controller.implementation.OrderRequestImpl;
import com.petstore.controller.initialization.OrderInit;
import com.petstore.controller.initialization.PetRequestInit;
import com.petstore.controller.initialization.RequestInitialization;
import com.petstore.controller.initialization.UserRequestInit;
import com.petstore.controller.services.EntityType;
import com.petstore.controller.services.RequestService;
import com.petstore.controller.util.RequestCommand;

public class MainMenu {

    private boolean exit;
    private RequestInitialization requestInit;
    private RequestCommand command;

    public void getRequestMethod() {
        EntityType entityType;
        do {
            entityType = RequestService.selectEntity();
            switch (entityType) {
                case PET: {
                    requestInit = new PetRequestInit();
                    break;
                }
                case ORDER: {
                    requestInit = new OrderInit();
                    break;
                }
                case USER: {
                    requestInit = new UserRequestInit();
                    break;
                }
                case EXIT: {
                    exit = true;
                    break;
                }
                default:
                    System.out.println("Incorrect try again");
                    getRequestMethod();
                    break;
            }
            if (!exit) {
                command = RequestService.selectCommand();
                switch (command) {
                    case GET: {
                        requestInit.requestType().getType();
                        break;
                    }
                    case PUT: {
                        requestInit.requestType().putType();
                        break;
                    }
                    case POST: {
                        requestInit.requestType().postType();
                        break;
                    }
                    case DELETE: {
                        requestInit.requestType().deleteType();
                        break;
                    }
                    case EXIT: {
                        exit = true;
                        break;
                    }
                    default:
                        System.out.println("Incorrect try again");
                        getRequestMethod();
                        break;
                }
            }
        } while (!exit);
        System.out.println("Goodbye !!!!!!!");
    }
}
