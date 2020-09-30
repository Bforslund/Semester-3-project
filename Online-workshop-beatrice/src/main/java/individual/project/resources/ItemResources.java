package individual.project.resources;

import individual.project.model.Item;
import individual.project.repository.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/items")
public class ItemResources {
    @Context
    private UriInfo uriInfo;
    public static final FakeDataStore fakeDataStore = new FakeDataStore();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllItems(@QueryParam("items") String items) {
        List<Item> itemList;
            itemList = fakeDataStore.GetItems();

        GenericEntity<List<Item>> entity = new GenericEntity<>(itemList) {  };
        return Response.ok(entity).build();
    }
    // Rebuild method below under later to filter items by type?
//    @GET //GET at http://localhost:XXXX/students?
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getAllItems(@QueryParam("type") String type) {
//        List<Item> items;
//        //If query parameter is missing return all students. Otherwise filter students by given countryCode
//        if (uriInfo.getQueryParameters().containsKey("type")){
//            Country country = fakeDataStore.getCountry(countryCode);
//            if (country == null){ // if country code invalid, return BAD_REQUEST
//                return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid country code.").build();
//            } else {
//                students = fakeDataStore.getStudents(country);
//            }
//        } else {
//            students = fakeDataStore.getStudents();
//        }
//        GenericEntity<List<Student>> entity = new GenericEntity<>(students) {  };
//        return Response.ok(entity).build();
//    }

    @POST //POST at http://localhost:XXXX/items/
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createItem(Item item) {
        if (!fakeDataStore.addItem(item)){
            String entity =  "Item with name " + item.getName() + " already exists.";
            return Response.status(Response.Status.CONFLICT).entity(entity).build();
        } else {
           String url = uriInfo.getAbsolutePath() + "/" + item.getName(); // url of the created item
            URI uri = URI.create(url);
            return Response.created(uri).build();
        }
    }
    @PUT //PUT at http://localhost:XXXX/items/
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateItem(Item item) {
        // Idempotent method. Always update (even if the resource has already been updated before).
        if (fakeDataStore.updateItem(item)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Please provide a valid id.").build();
        }
    }

    @DELETE //DELETE at http://localhost:XXXX/students/3
    @Path("{id}")
    public Response deleteStudent(@PathParam("id") int id) {
        fakeDataStore.deleteItem(id);
        // Idempotent method. Always return the same response (even if the resource has already been deleted before).
        return Response.noContent().build();
    }
}
