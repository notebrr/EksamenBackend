package entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dog_owner")
public class DogOwner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_name")
    private String userName;

    @ManyToMany
    @JoinTable(name = "dog_owner",
            joinColumns = @JoinColumn(name = "user_name"),
            inverseJoinColumns = @JoinColumn(name = "dog_id"))
    private List<DogOwner> dogs;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<DogOwner> getDogs() {
        return dogs;
    }

    public void setDogs(List<DogOwner> dogs) {
        this.dogs = dogs;
    }
}
