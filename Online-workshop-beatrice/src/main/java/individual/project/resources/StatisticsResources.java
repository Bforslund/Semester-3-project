package individual.project.resources;

import individual.project.controllers.StatisticsController;
import individual.project.model.*;
import individual.project.repository.*;

import javax.annotation.security.RolesAllowed;
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
    @RolesAllowed({"ADMIN"})
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
    @RolesAllowed({"ADMIN"})
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
    @RolesAllowed({"ADMIN"})
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
    @RolesAllowed({"ADMIN"})
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
    @RolesAllowed({"ADMIN"})
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
    @RolesAllowed({"ADMIN"})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllItems() {
        List<StatisticsOrder> statList;
        statList = statController.GetOrderPerMonth();

        GenericEntity<List<StatisticsOrder>> entity = new GenericEntity<>(statList) {  };
        return Response.ok(entity).build();
    }
}
