package individual.project.resources;


import individual.project.controllers.UserController;
import individual.project.model.Order;
import individual.project.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.core.Response;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserResourcesTest {
    @InjectMocks
    UserResources resources;

    @Mock
    UserController controller;

    @Test
    public void getAllUsers()  {
        when(controller.showAllUsers()).thenReturn(
                Arrays.asList(
                        new User()
                )
        );

        Response response = resources.getAllUsers();

        Assertions.assertEquals(response.getStatus(), 200);
    }
    @Test
    void testGettingAnUserById()  {
        when(controller.getUserFromToken("token")).thenReturn(new User());
        Response response = resources.getUserById("token");

        Assertions.assertEquals(response.getStatus(), 200);
    }
    @Test
    public void createUser() {
        User u = new User();
        when(controller.addUser(u)).thenReturn(true);

        Response response = resources.createUser(u);

        assertEquals(response.getStatus(), 201);
    }
    @Test
    public void updateUser() {
        User u = new User();
        when(controller.updateUser(u)).thenReturn(true);

        Response response = resources.updateUser(u);

        assertEquals(response.getStatus(), 204);
    }
    @Test
    public void updateUserPW() {
        User u = new User();
        when(controller.updatePassword(u)).thenReturn(true);

        Response response = resources.updatePassword(u);

        assertEquals(response.getStatus(), 204);
    }
    @Test
    public void deleteUser() {

        when(controller.deleteUser(1)).thenReturn(true);

        Response response = resources.deleteUser(1);

        assertEquals(response.getStatus(), 204);
    }

}
