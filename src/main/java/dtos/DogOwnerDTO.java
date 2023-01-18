package dtos;

import entities.Dog;
import entities.DogOwner;

import java.util.ArrayList;
import java.util.List;

public class DogOwnerDTO {
    public String userName;
    public List<DogOwnerDTO> dogs;

    public DogOwnerDTO(DogOwner dogOwner) {
        this.userName = dogOwner.getUserName();
        dogOwner.getDogs().forEach(user -> {
            dogs.add(new DogOwnerDTO(dogOwner));
        });

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<DogOwnerDTO> getDogs() {
        return dogs;
    }

    public void setDogs(List<DogOwnerDTO> dogs) {
        this.dogs = dogs;
    }

    public DogOwnerDTO(DogOwnerDTO dog) {
    }

    public static List<DogOwnerDTO> getDogOwnerDTOs(List<DogOwnerDTO> dogs) {
        List<DogOwnerDTO> dogDTOS = new ArrayList<>();
        dogs.forEach(dog -> dogDTOS.add(new DogOwnerDTO(dog)));
        return dogDTOS;
    }
}
