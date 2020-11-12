package com.petstore.controller.services;

import com.petstore.controller.util.RequestCommand;
import com.petstore.model.PetStatus;

import java.util.Optional;
import java.util.Scanner;

public class RequestService {
    public static Scanner scanner = new Scanner(System.in);

    public static long getLongId() {
        System.out.println("Enter Id");

        long id = 0;
        try {
            id = scanner.nextLong();
            return id;
        } catch (Exception e) {
            System.out.println("Wrong input format");
            getLongId();
        }
        return id;
    }

    public static PetStatus getPetStatus() {
        System.out.println("Enter pet status");
        String status = scanner.nextLine();
        Optional<PetStatus> petStatus = PetStatus.getPetStatus(status);
        return petStatus.orElseThrow(() -> new IllegalArgumentException("PetStatus value is wrong, try one more time"));
    }

    public static EntityType selectEntity() {
        System.out.println(" Chose Entity: \n (pet) \n (user) \n (order)()");
        EntityType entityType = null;
        try {
            entityType = entityType.getType(scanner.nextLine()).orElseThrow(() -> new IllegalArgumentException("Wrong input, try again"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            selectEntity();
        }
        return entityType;
    }

    public static RequestCommand selectCommand() {
        System.out.println("Select command: \n get \n put \n post \n delete");
        RequestCommand requestCommand = null;
        try {
            requestCommand = requestCommand.getCommand(scanner.nextLine()).orElseThrow(() -> new IllegalArgumentException("Wrong input, try again"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            selectCommand();
        }
        return requestCommand;
    }

    public static boolean exitCommand() {
        System.out.println("For exit type: \n (exit)");
        switch (scanner.nextLine()) {
            case "exit":
                return true;
            default:
                return false;
        }
    }
}