package individual.project.resources;

import individual.project.model.Order;
import individual.project.repository.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.*;
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
}

