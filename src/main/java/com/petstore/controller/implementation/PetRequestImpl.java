package com.petstore.controller.implementation;

import com.google.gson.reflect.TypeToken;
import com.petstore.controller.services.RequestService;
import com.petstore.model.*;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PetRequestImpl<T extends EntityPath> extends GenericRequest<Pet> implements RequestType {
    public Scanner scanner = new Scanner(System.in);


    @Override
    public void getType() {
        long id;
        PetStatus petStatus;
        Pet pet;
        String path;
        System.out.println("Select option:" +
                "\n get pet by Id: type (id)" +
                "\n get pet by status: type (status) ");
        String chose = scanner.nextLine();
        switch (chose) {
            case "id": {
                id = RequestService.getLongId();
                path = "/v2/pet/" + id;
                pet = getEntityByPath(path, Pet.class);
                System.out.println(pet);
                break;
            }
            case "status": {
                petStatus = RequestService.getPetStatus();
                path = "/v2/pet/findByStatus?status" + petStatus.getStatus();
                List<Pet> pets = getListEntity(path, new TypeToken<List<Pet>>(){}.getType());
                pets.stream().sorted(Comparator.comparingLong(p -> p.getId()))
                        .forEach(System.out::println);
                break;
            }
            default: {
                System.out.println("Wrong input");
            }
        }

    }

    @Override
    public void postType() {
        System.out.println("Input Pet");
        Pet pet = inputPet();
        String s = postEntity(pet);
        System.out.println(s);
    }

    @Override
    public void putType() {
        System.out.println("Update pet with id");
        Long petId = RequestService.getLongId();
        try {
            Pet pet = getEntityByPath("/v2/pet/" + petId, Pet.class);
            System.out.println("Enter new name");
            pet.setName(scanner.nextLine());
            String s=putEntity(pet);
            System.out.println(s);
        } catch (NullPointerException e) {
            System.out.println(String.format("Pet with ID %s wasn't found", petId));
        }
    }

    @Override
    public void deleteType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Api-key");
        String apiKey=scanner.nextLine();
        System.out.println();
        long id = RequestService.getLongId();
        String path=new Pet().getPath() +"/" +id;
        System.out.println();
        ApiResponse response =deleteEntity(path,apiKey);
        System.out.println(response);
    }

    private Pet inputPet(){
        System.out.println("Enter pet category");
        String categoryName=scanner.nextLine();
        System.out.println("Enter Pet name");
        String petName=scanner.nextLine();
       Pet pet= new Pet(0,petName,new Category(0,categoryName),null,null,PetStatus.AVAILABLE);
        return pet;
    }
}
