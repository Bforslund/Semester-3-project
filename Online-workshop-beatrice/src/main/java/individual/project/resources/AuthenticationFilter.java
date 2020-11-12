package individual.project.resources;

import individual.project.controllers.UserController;
import individual.project.model.User;

import javax.annotation.security.*;
import javax.ws.rs.container.*;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.Provider;
import java.lang.reflect.*;
import java.util.*;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter {

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
        //Get encoded username and password
        final String encodedCredentials =
                authorization.get(0).replaceFirst(AUTHENTICATION_SCHEME + " ", "");
        //Decode username and password into one string
        String credentials = new
                String(Base64.getDecoder().decode(encodedCredentials.getBytes()));
        //Split username and password tokens in credentials
        final StringTokenizer tokenizer = new StringTokenizer(credentials, ":");
        final String email = tokenizer.nextToken();
        final String password = tokenizer.nextToken();
        System.out.println(email);
        System.out.println(password);
        //Check if username and password are valid (e.g., database)
        //If not valid: abort with UNAUTHORIED and stop
        if (method.isAnnotationPresent(RolesAllowed.class)) {
            // get allowed roles for this method
            RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
            Set<String> rolesSet = new
                    HashSet<String>(Arrays.asList(rolesAnnotation.value()));
 /* isUserAllowed : implement this method to check if this user has any of
 the roles in the rolesSet
 if not isUserAllowed abort the requestContext with FORBIDDEN response*/
            if (!isUserAllowed(email, password, rolesSet)) {
                Response response = Response.status(Response.Status.FORBIDDEN).build();
                requestContext.abortWith(response);
                return;
            }
        }


        if (!isValidUser(email, password)) {
            Response response = Response.status(Response.Status.UNAUTHORIZED).
                    entity("Invalid email and/or password.").build();
            requestContext.abortWith(response);
            return;
        }
    }
   private boolean isValidUser(String email, String password) {
       UserController controller = new UserController();
       boolean valid;
      valid = controller.login(email, password);
      return valid;
    }

    private boolean isUserAllowed(String email, String password, Set<String> rolesSet){
        UserController controller = new UserController();
        String admin = "";
        if(rolesSet.contains("ADMIN")){
            admin = "ADMIN";
        }

       return controller.validateUser(email, password, admin);


    }
}