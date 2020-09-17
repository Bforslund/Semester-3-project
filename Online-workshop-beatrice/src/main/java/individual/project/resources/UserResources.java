package individual.project.resources;

import individual.project.model.Item;
import individual.project.model.Order;
import individual.project.model.User;
import individual.project.repository.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/users")
public class UserResources {
    @Context
    private UriInfo uriInfo;
    public static final FakeDataStore fakeDataStore = new FakeDataStore();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers(@QueryParam("users") String users) {
        List<User> UserList;
        UserList = fakeDataStore.getUserList();

        GenericEntity<List<User>> entity = new GenericEntity<>(UserList) {  };
        return Response.ok(entity).build();
    }
    @PUT //PUT at http://localhost:XXXX/items/
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateUser(User user) {
        // Idempotent method. Always update (even if the resource has already been updated before).
        if (fakeDataStore.updateUser(user)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Please provide a valid id.").build();
        }
    }

    @DELETE //DELETE at http://localhost:XXXX/students/3 works
    @Path("{id}")
    public Response deleteUser(@PathParam("id") int id) {
        fakeDataStore.deleteUser(id);
        // Idempotent method. Always return the same response (even if the resource has already been deleted before).
        return Response.noContent().build();
    }
}
