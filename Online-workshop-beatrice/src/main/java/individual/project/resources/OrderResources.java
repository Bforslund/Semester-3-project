package individual.project.resources;

import individual.project.model.Item;
import individual.project.model.Order;
import individual.project.model.OrderItem;
import individual.project.model.User;
import individual.project.repository.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Path("/orders")
public class OrderResources {
    @Context
    private UriInfo uriInfo;
    public static final FakeDataStore fakeDataStore = new FakeDataStore();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrders(@QueryParam("orders") String orders) {
        List<Order> OrderList;
        OrderList = fakeDataStore.GetOrders();

        GenericEntity<List<Order>> entity = new GenericEntity<>(OrderList) {  };
        return Response.ok(entity).build();
    }
    @GET
    @Path("order/{orderNumber}/orderitems") // Get orderItems from an order
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrderItems(@PathParam("orderNumber") int orderNr) {
        List<OrderItem> OrderItemList;
        OrderItemList = fakeDataStore.getAllOrderItems(orderNr);

        GenericEntity<List<OrderItem>> entity = new GenericEntity<>(OrderItemList) {  };
        return Response.ok(entity).build();
    }
    @GET
    @Path("order/{id}") // Get one order
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderById(@PathParam("id") int id) {
        Order o = fakeDataStore.getOrder(id);//studentsRepository.get(stNr);
        User u = fakeDataStore.getUserFromOrderId(id);
        if (o == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid user id.").build();
        } else {
            return Response.ok(o).build();
        }
    }
    @GET
    @Path("order/{id}/user") // Get one order
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByOrderId(@PathParam("id") int id) {

        User u = fakeDataStore.getUserFromOrderId(id);
        if (u == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid user id.").build();
        } else {
            return Response.ok(u).build();
        }
    }
    @POST //POST at http://localhost:XXXX/items/
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOrder(Order order) {
        if (!fakeDataStore.addOrder(order)){
            String entity =  "Order with ordernumber " + order.getOrderNumber() + " already exists.";
            return Response.status(Response.Status.CONFLICT).entity(entity).build();
        } else {
            String url = uriInfo.getAbsolutePath() + "/" + order.getOrderNumber(); // url of the created order
            URI uri = URI.create(url);
            return Response.created(uri).build();
        }
    }
    @PUT //PUT at http://localhost:XXXX/orders/id
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOrder(Order order) {
        // Idempotent method. Always update (even if the resource has already been updated before).
        if (fakeDataStore.updateOrder(order)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Please provide a valid id.").build();
        }
    }

    @DELETE //DELETE at http://localhost:XXXX/orders/3 works
    @Path("deleteAll")
    public Response deleteAllOrders() {
        fakeDataStore.deleteAllOrder();
        // Idempotent method. Always return the same response (even if the resource has already been deleted before).
        return Response.noContent().build();
    }
    @GET
    @Path("user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrdersOfUser(@PathParam("id") int id) {
        List<Order> OrderList;
        OrderList = fakeDataStore.GetAllOrdersOfUser(id);

        GenericEntity<List<Order>> entity = new GenericEntity<>(OrderList) {  };
        return Response.ok(entity).build();
    }
}

