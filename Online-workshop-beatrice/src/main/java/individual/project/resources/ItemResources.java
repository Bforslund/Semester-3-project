package individual.project.resources;

import individual.project.controllers.ItemController;
import individual.project.model.Item;


import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/items")
public class ItemResources {
    @Context
    private UriInfo uriInfo;
    public static final ItemController itemController = new ItemController();
    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllItems(@QueryParam("items") String items) {
        List<Item> itemList;
            itemList = itemController.showAllItems();

        GenericEntity<List<Item>> entity = new GenericEntity<>(itemList) {  };
        return Response.ok(entity).build();
    }

    @POST //POST at http://localhost:XXXX/items/
    @RolesAllowed({"ADMIN"})
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createItem(Item item) {
        if (!itemController.addItem(item)){
            String entity =  "Item with name " + item.getName() + " already exists.";
            return Response.status(Response.Status.CONFLICT).entity(entity).build();
        } else {
           String url = uriInfo.getAbsolutePath() + "/" + item.getId(); // url of the created item
            URI uri = URI.create(url);
            return Response.created(uri).build();
        }

    }
    @PUT //PUT at http://localhost:XXXX/items/
    @RolesAllowed({"ADMIN"})
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateItem(Item item) {

        try{
            itemController.UpdateItem(item);
            return Response.noContent().build();
        }catch(Exception e){
            return Response.status(Response.Status.NOT_FOUND).entity("Please provide a valid id.").build();
        }
    }

    @DELETE //DELETE at http://localhost:XXXX/students/3
    @RolesAllowed({"ADMIN"})
    @Path("{id}")
    public Response deleteItem(@PathParam("id") int id) {
        itemController.DeleteItem(id);
        return Response.noContent().build();
    }
}
