package rest;

import businessfacades.UserDTOFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.DogDTO;
import dtos.UserDTO;
import entities.User;

import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import errorhandling.API_Exception;
import errorhandling.NotFoundException;
import utils.EMF_Creator;

/**
 * @author lam@cphbusiness.dk
 */
@Path("users")
public class UserResource {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private UserDTOFacade facade = UserDTOFacade.getInstance(EMF);
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    @GET
    @Path("/{userName}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getById(@PathParam("userName") String userName) throws API_Exception {
        return Response.ok().entity(GSON.toJson(facade.getUserByUserName(userName))).type(MediaType.APPLICATION_JSON_TYPE.withCharset(StandardCharsets.UTF_8.name())).build();
    }

    @GET
    @Path("/all")
    public Response getAllUsers() throws API_Exception {
        return Response.ok().entity(GSON.toJson(facade.getAllUsers())).type(MediaType.APPLICATION_JSON_TYPE.withCharset(StandardCharsets.UTF_8.name())).build();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(String content) throws API_Exception {
        UserDTO userDTO = GSON.fromJson(content, UserDTO.class);
        UserDTO newUserDTO = facade.createUser(userDTO);
        return Response.ok().entity(GSON.toJson(newUserDTO)).type(MediaType.APPLICATION_JSON_TYPE.withCharset(StandardCharsets.UTF_8.name())).build();
    }

    @PUT
    @Path("/{userName}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response update(@PathParam("userName")String userName, String content) throws EntityNotFoundException, API_Exception {
        UserDTO udto = GSON.fromJson(content, UserDTO.class);
        udto.setUserName(userName);
        UserDTO updatedUser = facade.updateUser(udto);
        return Response.ok().entity(GSON.toJson(updatedUser)).type(MediaType.APPLICATION_JSON_TYPE.withCharset(StandardCharsets.UTF_8.name())).build();
    }

    @DELETE
    @Path("/{userName}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response deleteUser(@PathParam("userName") String userName) throws API_Exception {
        UserDTO deletedUser = facade.deleteUser(userName);
        return Response.ok().entity(GSON.toJson(deletedUser)).type(MediaType.APPLICATION_JSON_TYPE.withCharset(StandardCharsets.UTF_8.name())).build();
    }

    //US-1
    @GET
    @Path("/all/walkers")
    public Response getAllWalkers() throws API_Exception {
        return Response.ok().entity(GSON.toJson(facade.getAllWalkers())).type(MediaType.APPLICATION_JSON_TYPE.withCharset(StandardCharsets.UTF_8.name())).build();
    }

    //US-2
    @GET
    @Path("/all/owner/{userName}")
    public Response getAllDogsFromOwner(@PathParam("userName") String userName) throws API_Exception {
        return Response.ok().entity(GSON.toJson(facade.getAllWalkers())).type(MediaType.APPLICATION_JSON_TYPE.withCharset(StandardCharsets.UTF_8.name())).build();
    }

    //US-3
    @GET
    @Path("/all/walker/{userName}")
    public Response getAllDogsFromWalker(@PathParam("userName") String userName) throws API_Exception {
        return Response.ok().entity(GSON.toJson(facade.getAllWalkers())).type(MediaType.APPLICATION_JSON_TYPE.withCharset(StandardCharsets.UTF_8.name())).build();
    }

    //US-4
    @Path("/dog")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addDog(String content) throws API_Exception {
        DogDTO dogDTO = GSON.fromJson(content, DogDTO.class);
        DogDTO upload = facade.addNewDog(dogDTO);
        return Response.ok().entity(GSON.toJson(upload)).type(MediaType.APPLICATION_JSON_TYPE.withCharset(StandardCharsets.UTF_8.name())).build();
    }

    // US-6
    @PUT
    @Path("/dog/update")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateDog(String content) throws EntityNotFoundException, API_Exception {
        DogDTO dogDTO = GSON.fromJson(content, DogDTO.class);
        DogDTO updateDog = facade.updateDog(dogDTO);
        return Response.ok().entity(GSON.toJson(updateDog)).type(MediaType.APPLICATION_JSON_TYPE.withCharset(StandardCharsets.UTF_8.name())).build();
    }

    //US- 7
    @DELETE
    @Path("/dog/{dogId}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response deleteDog(@PathParam("dogId") int dogId) throws API_Exception {
        DogDTO deletedDog = facade.deleteDog(dogId);
        return Response.ok().entity(GSON.toJson(deletedDog)).type(MediaType.APPLICATION_JSON_TYPE.withCharset(StandardCharsets.UTF_8.name())).build();
    }

    //Extra
    @GET
    @Path("/dogs/all")
    public Response getAllDogs() throws API_Exception {
        return Response.ok().entity(GSON.toJson(facade.getAllDogs())).type(MediaType.APPLICATION_JSON_TYPE.withCharset(StandardCharsets.UTF_8.name())).build();
    }
}