package individual.project.resources;

import individual.project.controllers.ItemController;
import individual.project.model.User;
import individual.project.controllers.UserController;

import javax.annotation.security.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

@Path("/users")
public class UserResources {
    @Context
    private UriInfo uriInfo;
    public static final UserController userController = new UserController();
    @GET
    @RolesAllowed({"ADMIN"})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers(@QueryParam("users") String users) {
        List<User> UserList;
        UserList = userController.showAllUsers();

        GenericEntity<List<User>> entity = new GenericEntity<>(UserList) {  };
        return Response.ok(entity).build();
    }

    @GET
    @Path("me")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@HeaderParam("Authorization") String token) {
        User user = userController.getUserFromToken(token);
        if (user.equals(null)) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid user id.").build();
        } else {
            return Response.ok(user).build();
        }
    }
    @POST //POST at http://localhost:XXXX/users/
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {// register
        if (!userController.addUser(user)){
            String entity =  "user with email " + user.getEmail() + " already exists.";
            return Response.status(Response.Status.CONFLICT).entity(entity).build();
        } else {
            String url = uriInfo.getAbsolutePath() + "/" + user.getId(); // url of the created item
            URI uri = URI.create(url);
            return Response.created(uri).build();
        }
    }
    @POST //POST at http://localhost:XXXX/users/
    @Path("login")
    @PermitAll
    @Produces("text/plain")
    public Response LoginUser(String body) {
        final StringTokenizer tokenizer = new StringTokenizer(body, ":");
        final String email = tokenizer.nextToken();
        final String password = tokenizer.nextToken();
      User user =  userController.getUserByEmail(email);
        if (userController.login(email, password)){
            String userId = Integer.toString(user.getId());
            String token = userController.createJWT(userId, user.getFirstName(),user.getLastName(), -1);
            return Response.ok(token).build();
        } else {
           return Response.status(Response.Status.NOT_FOUND).entity("Please provide a valid email.").build();
        }
    }
    @PUT //Update user from admin
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(User user) {
        if (userController.updateUser(user)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Please provide a valid id.").build();
        }
    }

    //Duplicated
//    @PUT //PUT at http://localhost:XXXX/items/
//    @Path("user/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response updateUser(@PathParam("id") int id, User user) {
//        // Idempotent method. Always update (even if the resource has already been updated before).
//        if (userController.updateUser(user, id)) {
//            return Response.noContent().build();
//        } else {
//            return Response.status(Response.Status.NOT_FOUND).entity("Please provide a valid id.").build();
//        }
//    }


    @DELETE //DELETE at http://localhost:XXXX/students/3 works
    @RolesAllowed({"ADMIN"})
    @Path("{id}")
    public Response deleteUser(@PathParam("id") int id) {
        userController.deleteUser(id);
        // Idempotent method. Always return the same response (even if the resource has already been deleted before).
        return Response.noContent().build();
    }
}
