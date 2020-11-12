package com.petstore;

import com.petstore.controller.initialization.PetRequestInit;
import com.petstore.controller.initialization.RequestInitialization;
import com.petstore.controller.services.EntityType;
import com.petstore.controller.services.RequestService;
import com.petstore.controller.util.RequestCommand;

public class MainMenu {

    private boolean exit;
    private RequestInitialization requestInit;

    public void getRequestMethod() {
        EntityType entityType;
        do {
            entityType = RequestService.selectEntity();

            switch (entityType) {
                case PET: {
                    requestInit = new PetRequestInit();
                    RequestCommand command = RequestService.selectCommand();
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
                    }
                    break;
                }
                default:
                    break;
            }
            exit = RequestService.exitCommand();
        } while (!exit);
        System.out.println("Goodbye !!!!!!!");

    }

}