package individual.project.resources;
import individual.project.controllers.*;
import individual.project.model.*;
import individual.project.repository.*;


import javax.annotation.security.PermitAll;

import javax.annotation.security.RolesAllowed;
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


@Path("/recipes")
public class RecipeResources {
    @Context
    private UriInfo uriInfo;
    public RecipeController controller = new RecipeController();

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRecipes() {
        List<Recipe> recipeList;
        recipeList = controller.showAllRecipes();

        GenericEntity<List<Recipe>> entity = new GenericEntity<>(recipeList) {
        };
        return Response.ok(entity).build();
    }
    @POST //POST at http://localhost:XXXX/items/
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createRecipe(Recipe recipe) {
        if (!controller.addRecipe(recipe)){
            String entity =  "Item with name " + recipe.getTitle() + " already exists.";
            return Response.status(Response.Status.CONFLICT).entity(entity).build();
        } else {
          //  String url = uriInfo.getAbsolutePath() + "/" + recipe.getId(); // url of the created item
            URI uri = URI.create("created");
            return Response.created(uri).build();
        }

    }
}
