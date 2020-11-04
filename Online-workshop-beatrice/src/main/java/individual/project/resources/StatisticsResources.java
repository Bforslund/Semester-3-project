package individual.project.resources;

import individual.project.controllers.StatisticsController;
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
    public static final StatisticsController statController = new StatisticsController();
    @GET
    @Path("revenue")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTotalRevenue() {
        double total = 0;
        total = statController.GetTotalRevenue();

        if (total == -1) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid total.").build();
        } else {
            return Response.ok(total).build();
        }
    }
    @GET
    @Path("cakes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTotalCakesSold() {
        double total = 0;
        total = statController.GetTotalAmountOfCakesSold();

        if (total == -1) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid total.").build();
        } else {
            return Response.ok(total).build();
        }
    }
    @GET
    @Path("cookies")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTotalCookiesSold() {
        double total = 0;
        total = statController.GetTotalAmountOfCookiesSold();

        if (total == -1) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid total.").build();
        } else {
            return Response.ok(total).build();
        }
    }
    @GET
    @Path("cupcakes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTotalCupcakesSold() {
        double total = 0;
        total = statController.GetTotalAmountOfCupcakesSold();

        if (total == -1) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid total.").build();
        } else {
            return Response.ok(total).build();
        }
    }
    @GET
    @Path("other")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTotalOtherSold() {
        double total = 0;
        total = statController.GetTotalAmountOfOtherSold();

        if (total == -1) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid total.").build();
        } else {
            return Response.ok(total).build();
        }
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllItems() {
        List<StatisticsOrder> statList;
        statList = statController.GetOrderPerMonth();

        GenericEntity<List<StatisticsOrder>> entity = new GenericEntity<>(statList) {  };
        return Response.ok(entity).build();
    }
}
