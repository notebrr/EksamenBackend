package businessfacades;

import dtos.DogDTO;
import dtos.UserDTO;
import entities.Dog;
import entities.User;
import errorhandling.API_Exception;
import errorhandling.NotFoundException;
import datafacades.UserFacade;
import security.errorhandling.AuthenticationException;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UserDTOFacade {

    private static UserDTOFacade instance;
    private static UserFacade userFacade;

    private UserDTOFacade() {}

    public static UserDTOFacade getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            userFacade = UserFacade.getUserFacade(_emf);
            instance = new UserDTOFacade();
        }
        return instance;
    }

    public UserDTO getVerifiedUser(String username, String userpass) throws AuthenticationException {
        return new UserDTO(userFacade.getVerifiedUser(username,userpass));
    }
    public UserDTO createUser(UserDTO userDTO) throws API_Exception {
        return new UserDTO(userFacade.createUser(userDTO.getEntity()));
    }
    public UserDTO updateUser(UserDTO userDTO) throws API_Exception {
        return new UserDTO(userFacade.updateUser(userDTO.getEntity()));
    }
    public UserDTO getUserByUserName(String userName) throws API_Exception {
        return new UserDTO(userFacade.getUserByUserName(userName));
    }
    public List<UserDTO> getAllUsers() throws API_Exception {
        return UserDTO.getUserDTOs(userFacade.getAllUsers());
    }
    public UserDTO deleteUser(String userName) throws API_Exception {
        return new UserDTO(userFacade.deleteUser(userName));
    }

    //
    public List<UserDTO> getAllWalkers() throws API_Exception {
        return UserDTO.getUserDTOs(userFacade.getAllWalkers());
    }

    public List<DogDTO> getAllDogsFromOwner(String userName) throws API_Exception {
        return DogDTO.getDogDTOs(userFacade.getAllDogsFromOwner(userName));
    }

    public DogDTO addNewDog(DogDTO dogDTO) throws API_Exception {
        return new DogDTO(userFacade.addNewDog(dogDTO.getEntity()));
    }

    public DogDTO deleteDog(int dogId) throws API_Exception {
        return new DogDTO(userFacade.deleteDog(dogId));
    }

    public DogDTO updateDog(DogDTO dogDTO) throws API_Exception {
        return new DogDTO(userFacade.update(dogDTO.getEntity()));
    }

    //Extra
    public List<DogDTO> getAllDogs() throws API_Exception {
        return DogDTO.getDogDTOs(userFacade.getAllDogs());
    }
}
