package individual.project.resources;

import individual.project.controllers.ItemController;
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
    public static final ItemController ITEM_CONTROLLER = new ItemController();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllItems(@QueryParam("items") String items) {
        List<Item> itemList;
            itemList = ITEM_CONTROLLER.showAllItems();

        GenericEntity<List<Item>> entity = new GenericEntity<>(itemList) {  };
        return Response.ok(entity).build();
    }

    @POST //POST at http://localhost:XXXX/items/
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createItem(Item item) {

        try{
            ITEM_CONTROLLER.addItem(item);
            String url = uriInfo.getAbsolutePath() + "/" + item.getName(); // url of the created item
            URI uri = URI.create(url);
            return Response.created(uri).build();
        }catch(Exception e){
            String entity =  "Item with name " + item.getName() + " already exists.";
            return Response.status(Response.Status.CONFLICT).entity(entity).build();
        }
//        if (!fakeDataStore.addItem(item)){
//            String entity =  "Item with name " + item.getName() + " already exists.";
//            return Response.status(Response.Status.CONFLICT).entity(entity).build();
//        } else {
//           String url = uriInfo.getAbsolutePath() + "/" + item.getName(); // url of the created item
//            URI uri = URI.create(url);
//            return Response.created(uri).build();
//        }
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
