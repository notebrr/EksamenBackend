package dtos;

import entities.Dog;
import entities.Role;
import entities.User;
import org.mindrot.jbcrypt.BCrypt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DogDTO {
    private int dog_id;
    private String dogName;
    private String gender;
    private String birthdate;
    private String breed;
    private List<DogDTO> dogList;

    public int getDog_id() {
        return dog_id;
    }

    public void setDog_id(int dog_id) {
        this.dog_id = dog_id;
    }

    public List<DogDTO> getDogList() {
        return dogList;
    }

    public DogDTO(Dog dog) {
        /*
        dog.getDogList().forEach(user -> {
            dogList.add(new DogDTO(dog));
        });

         */
        this.dogName = dog.getDogName();
        this.gender = dog.getGender();
        this.birthdate = dog.getBirthdate();
        this.breed = dog.getBreed();
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }


    public void setDogList(List<DogDTO> dogList) {
        this.dogList = dogList;
    }


    public static List<DogDTO> getDogDTOs(List<Dog> dogs) {
        List<DogDTO> dogDTOS = new ArrayList<>();
        dogs.forEach(dog -> dogDTOS.add(new DogDTO(dog)));
        return dogDTOS;
    }

    public Dog getEntity(){
        Dog dog = new Dog();
        dog.setDogId(this.dog_id);
        dog.setDogName(this.dogName);
        dog.setBirthdate(this.birthdate);
        dog.setBreed(this.breed);
        dog.setGender(this.gender);
        return dog;
    }

}
