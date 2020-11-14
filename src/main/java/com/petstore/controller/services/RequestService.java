package com.petstore.controller.services;

import com.petstore.controller.util.RequestCommand;
import com.petstore.model.PetStatus;

import java.util.Optional;
import java.util.Scanner;

public class RequestService {
    public static Scanner scanner = new Scanner(System.in);

    public static long getLongId() {
        boolean idProvide = false;
        long id = 0;
        while (!idProvide) {
            try {
                System.out.println("Enter Id long");
                id = scanner.nextLong();
                idProvide = true;
            } catch (Exception e) {
                System.out.println("Wrong input format try again");
                getLongId();
            }
        }
        return id;
    }

    public static PetStatus getPetStatus() {
        PetStatus petStatus = null;
        boolean petStatusIs = false;
        while (!petStatusIs) {
            System.out.println("Enter pet status");
            String status = scanner.nextLine();
            try {
                petStatus = PetStatus.getPetStatus(status).orElseThrow(() -> new IllegalArgumentException("incorrect input"));
                petStatusIs = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return petStatus;
    }

    public static EntityType selectEntity() {
        boolean entityIs = false;
        EntityType entityType = null;
        while (!entityIs) {
            System.out.println(" Chose Entity: \n (pet) \n (user) \n (order) \n exit");
            String entity = scanner.next();
            try {
                entityType = entityType.getType(entity).orElseThrow(() -> new IllegalArgumentException("Wrong input, try again"));
                entityIs = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return entityType;
    }

    public static RequestCommand selectCommand() {
        boolean commandIs = false;
        RequestCommand command = null;
        while (!commandIs) {
            System.out.println("Select command: \n get \n put \n post \n delete \n exit ");
            String commandString = scanner.next();
            try {
                command = RequestCommand.getCommand(commandString).orElseThrow(() -> new IllegalArgumentException("Wrong input, try again"));
                commandIs = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return command;
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