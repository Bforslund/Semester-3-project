package individual.project.resources;
import individual.project.model.*;
import individual.project.repository.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/statistics")
public class StatisticsResources {
    @Context
    private UriInfo uriInfo;
    public static final FakeDataStatistics fakeDataStatistics = new FakeDataStatistics();
    @GET
    @Path("revenue")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTotalRevenue() {
        double total = 0;
        total = fakeDataStatistics.GetTotalRevenue();

        if (total == -1) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid user id.").build();
        } else {
            return Response.ok(total).build();
        }
    }
}
