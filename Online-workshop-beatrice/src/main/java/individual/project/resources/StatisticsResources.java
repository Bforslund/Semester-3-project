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
//    @GET
//    @Path("revenue")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getTotalRevenue() {
//        double total = 0;
//        total = fakeDataStatistics.GetTotalRevenue();
//
//        if (total == -1) {
//            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid total.").build();
//        } else {
//            return Response.ok(total).build();
//        }
//    }
//    @GET
//    @Path("cakes")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getTotalCakesSold() {
//        double total = 0;
//        total = fakeDataStatistics.GetTotalAmountOfCakesSold();
//
//        if (total == -1) {
//            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid total.").build();
//        } else {
//            return Response.ok(total).build();
//        }
//    }
//    @GET
//    @Path("cookies")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getTotalCookiesSold() {
//        double total = 0;
//        total = fakeDataStatistics.GetTotalAmountOfCookiesSold();
//
//        if (total == -1) {
//            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid total.").build();
//        } else {
//            return Response.ok(total).build();
//        }
//    }
//    @GET
//    @Path("cupcakes")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getTotalCupcakesSold() {
//        double total = 0;
//        total = fakeDataStatistics.GetTotalAmountOfCupcakesSold();
//
//        if (total == -1) {
//            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid total.").build();
//        } else {
//            return Response.ok(total).build();
//        }
//    }
//    @GET
//    @Path("other")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getTotalOtherSold() {
//        double total = 0;
//        total = fakeDataStatistics.GetTotalAmountOfOtherSold();
//
//        if (total == -1) {
//            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid total.").build();
//        } else {
//            return Response.ok(total).build();
//        }
//    }
}
