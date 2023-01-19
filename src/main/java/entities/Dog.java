package entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@NamedQuery(name = "Dog.deleteAllRows", query = "DELETE from Dog")
@Table(name = "dog")
public class Dog implements Serializable {
    public Dog(int dogId, String dogName, String gender, String birthdate, String breed) {
        this.dogId = dogId;
        this.dogName = dogName;
        this.gender = gender;
        this.birthdate = birthdate;
        this.breed = breed;
    }
    public Dog(){

    }

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dog_id")
    private int dogId;


    @Basic(optional = false)
    @NotNull
    @Column(name = "dog_name")
    private String dogName;

    @Basic(optional = false)
    @NotNull
    @Column(name = "gender")
    private String gender;

    @Basic(optional = false)
    @NotNull
    @Column(name = "birthdate")
    private String birthdate;

    @Basic(optional = false)
    @NotNull
    @Column(name = "breed")
    private String breed;

    /*
    @JoinTable(name = "dog_owner", joinColumns = {
            @JoinColumn(name = "dog_id", referencedColumnName = "dog_id")}, inverseJoinColumns = {
            @JoinColumn(name = "user_name", referencedColumnName = "user_name")})

     */


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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return dogName.equals(dog.dogName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dogName);
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }
    public int getDogId() {
        return dogId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }


}