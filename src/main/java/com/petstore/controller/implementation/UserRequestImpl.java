package com.petstore.controller.implementation;

import com.google.gson.reflect.TypeToken;
import com.petstore.controller.services.RequestService;
import com.petstore.model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UserRequestImpl extends GenericRequest<User> implements RequestType {
    public Scanner scanner = new Scanner(System.in);
    private User user = new User();


    @Override
    public void getType() {
        System.out.println("Enter user name:");
        String name = scanner.nextLine();
        String path = user.getPath() + "/" + name;
        user = getEntityByPath(path, User.class);
        if (user.getId() == 0) {
            System.out.println("user not found");
        } else {
            System.out.println(user);
        }

    }


    @Override
    public void postType() {
        String fistName;
        String lastName;
        String email;
        user = null;
        System.out.println("Enter user fist name");
        fistName = scanner.nextLine();
        System.out.println("Enter user last name");
        lastName = scanner.nextLine();
        email = String.format("%s.%s@gmail.com", fistName, lastName);
        user = new User(0, fistName, lastName, email, email, "555555", "6666666", 1);
        String result = postEntity(user);
        System.out.println(result);
    }


    @Override
    public void putType() {
        System.out.println("To change your user please login");
        user = login();
        user.setPath(user.getPath() + "/" + user.getUserName());
        if (user != null) {
            System.out.println("Select what to change (first_name),(last_name),(email),(phone)");
            String answer = scanner.next();
            switch (answer) {
                case "first_name": {
                    System.out.println("Enter new fist name");
                    user.setFistName(scanner.nextLine());
                    break;
                }
                case "last_name": {
                    System.out.println("Enter new last name");
                    user.setLastName(scanner.nextLine());
                    break;
                }
                case "email": {
                    System.out.println("Enter new email name");
                    user.setEmail(scanner.nextLine());
                    break;
                }
                case "phone": {
                    System.out.println("Enter new phone name");
                    user.setPhone(scanner.nextLine());
                    break;
                }
                default: {
                    System.out.println("Incorrect input , try again");
                    putType();
                    break;
                }
            }
            String result = putEntity(user);
            System.out.println(result);
            user.setPath("/v2/user");
            logOut();
        }
    }

    @Override
    public void deleteType() {
        System.out.println("Enter Api-key");
        String apiKey = scanner.nextLine();
        System.out.println("Enter user name");
        String name = scanner.nextLine();
        String path=new User().getPath()+"/"+ name;
        ApiResponse result = deleteEntity(path, apiKey);
        System.out.println(result);
    }



    public User login() {
        System.out.println("Enter user Name");
        String name = scanner.next();
        System.out.println("Enter password");
        String pass = scanner.next();
        String answer = getStringResult(user.getPath() + "/login?username" + name + "&password=" + pass);
        System.out.println(answer);
        user = getEntityByPath(user.getPath() + "/" + name, User.class);
        return user;
    }

    public void logOut() {
        String answer = getStringResult(user.getPath() + "/logout");
        System.out.println(answer);
    }


}


