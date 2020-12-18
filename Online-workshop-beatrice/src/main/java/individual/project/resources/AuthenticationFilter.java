package individual.project.resources;

import individual.project.controllers.UserController;
import individual.project.model.User;
import io.jsonwebtoken.Claims;

import javax.annotation.security.*;
import javax.ws.rs.container.*;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.Provider;
import java.lang.reflect.*;
import java.util.*;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter {
    UserController controller = new UserController();
    @Context
    private ResourceInfo resourceInfo;
    // requestContext contains information about the HTTP request message


    @Override
    public void filter(ContainerRequestContext requestContext)
    {

        Method method = resourceInfo.getResourceMethod();

        if (method.isAnnotationPresent(PermitAll.class)) {
            return;
        }

        final String AUTHORIZATION_PROPERTY = "Authorization";
        final String AUTHENTICATION_SCHEME = "Basic";

        //Get request headers
        final MultivaluedMap<String, String> headers = requestContext.getHeaders();
        //Fetch authorization header
        final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);
        //If no authorization information present: abort with UNAUTHORIZED and stop
        if (authorization == null || authorization.isEmpty()) {
            Response response = Response.status(Response.Status.UNAUTHORIZED).
                    entity("Missing username and/or password.").build();
            requestContext.abortWith(response);
            return;
        }
        final String token = authorization.get(0);
        Claims decoded = controller.decodeJWT(token);
        // If i can decode it it is valid
        String id = decoded.getId();
        if(id.isEmpty()){
            System.out.println("Invalid user");
            Response response = Response.status(Response.Status.UNAUTHORIZED).
                    entity("Invalid email and/or password.").build();
            requestContext.abortWith(response);
            return;
        }
        //Check if username and password are valid (e.g., database)
        //If not valid: abort with UNAUTHORIED and stop
        if (method.isAnnotationPresent(RolesAllowed.class)) {
            RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
            Set<String> rolesSet = new
                    HashSet<String>(Arrays.asList(rolesAnnotation.value()));
            if (!isUserAllowed(id, rolesSet)) {
                Response response = Response.status(Response.Status.FORBIDDEN).build();
                requestContext.abortWith(response);
                return;
            }
        }

    }


    private boolean isUserAllowed(String id, Set<String> rolesSet){

        String admin = "";
        if(rolesSet.contains("ADMIN")){
            admin = "ADMIN";
        }

       return controller.validateUser(id, admin);


    }
}
