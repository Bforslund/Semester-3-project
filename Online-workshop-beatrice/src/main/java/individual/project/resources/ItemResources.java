package individual.project.resources;

import individual.project.controllers.ItemController;
import individual.project.model.Item;
import individual.project.model.Order;
import individual.project.repository.HibernateItemsRepository;


import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletMapping;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.CompletionCallback;
import javax.ws.rs.container.ConnectionCallback;
import javax.ws.rs.container.TimeoutHandler;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.ws.rs.container.*;


@Path("/items")
public class ItemResources {
    @Context
    private UriInfo uriInfo;
    public static final ItemController itemController = new ItemController(new HibernateItemsRepository());

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllItems(@QueryParam("items") String items) {
        List<Item> itemList;
        itemList = itemController.showAllItems();

        GenericEntity<List<Item>> entity = new GenericEntity<>(itemList) {
        };
        return Response.ok(entity).build();
    }
    @GET
    @PermitAll
    @Path("item/{id}") // Get one item
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderById(@PathParam("id") int id) {
        Item o = itemController.getItemById(id);//studentsRepository.get(stNr);
        if (o == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid item id.").build();
        } else {
            return Response.ok(o).build();
        }
    }
    @GET
    @PermitAll
    @Path("{term}")
    @Produces(MediaType.APPLICATION_JSON)
    public void getAllSearchItems(@PathParam("term") String term, @Suspended final AsyncResponse asyncResponse) {
        asyncResponse.setTimeoutHandler(new TimeoutHandler() {  // register the TimeoutHandler

            @Override
            public void handleTimeout(AsyncResponse asyncResponse) {
                asyncResponse.resume(Response.status(Response.Status.SERVICE_UNAVAILABLE)
                        .entity("Operation time out.").build());
            }
        });
        asyncResponse.setTimeout(100, TimeUnit.MILLISECONDS); // set the timeout interval

        asyncResponse.register(new ConnectionCallback() { // register a ConnectionCallback listener
            @Override
            public void onDisconnect(AsyncResponse disconnected) {
                System.out.println("Connection to the client is closed or lost!");
            }
        });

        asyncResponse.register(new CompletionCallback() { // register a CompletionCallback listener
            @Override
            public void onComplete(Throwable throwable) {
                System.out.println("Processing is complete!");
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Item> itemList;
                itemList = itemController.search(term);

                asyncResponse.resume(Response.ok(itemList).build());
            }
        }).start();
    }

    @GET
    @PermitAll
    @Path("{type}/{price}")
    @Produces(MediaType.APPLICATION_JSON)
    public void getAllFilteredItems(@PathParam("type") String type, @PathParam("price") double price, @Suspended final AsyncResponse asyncResponse) {
        Item.TypeOfItem itemType = itemController.MakeToEnum(type);
        asyncResponse.setTimeoutHandler(new TimeoutHandler() {  // register the TimeoutHandler

            @Override
            public void handleTimeout(AsyncResponse asyncResponse) {
                asyncResponse.resume(Response.status(Response.Status.SERVICE_UNAVAILABLE)
                        .entity("Operation time out.").build());
            }
        });
        asyncResponse.setTimeout(100, TimeUnit.MILLISECONDS); // set the timeout interval

        asyncResponse.register(new ConnectionCallback() { // register a ConnectionCallback listener
            @Override
            public void onDisconnect(AsyncResponse disconnected) {
                System.out.println("Connection to the client is closed or lost!");
            }
        });

        asyncResponse.register(new CompletionCallback() { // register a CompletionCallback listener
            @Override
            public void onComplete(Throwable throwable) {
                System.out.println("Processing is complete!");
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Item> itemList;
                itemList = itemController.filterByType(itemType,price);

                asyncResponse.resume(Response.ok(itemList).build());
            }
        }).start();
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
