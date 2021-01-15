package individual.project.controllers;

import individual.project.model.User;
import individual.project.repository.FakeUsersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class UserControllerTest {

    UserController controller = new UserController(new FakeUsersRepository());

    @Test
    public void getUserByEmail() {
        User u = new User("Beatrice", "Forslund", "Nijmegen", "1999-10-21", "Bea@gmail.com", "1234");

        User expected =  controller.getUserByEmail("Bea@gmail.com");

        assertEquals(expected.getFirstName(), u.getFirstName());

    }
    @Test
    public void loginAndHashingTest()  {
        String password = controller.doHashing("1234");
        User u = new User("Beatrice", "Forslund", "Nijmegen", "1999-10-21", "Bea@gmail.com", "1234");

        Boolean expected =  controller.login("Bea@gmail.com", "1234");

        assertEquals(true, expected);

    }
    @Test
    public void getUserFromToken()  {

        User u = new User("Beatrice", "Forslund", "Nijmegen", "1999-10-21", "Bea@gmail.com", "1234");
        u.setId(1);
        String userId = Integer.toString(u.getId());
        String token = controller.createJWT(userId, "Beatrice", "Forslund", -1);

        User expected =  controller.getUserFromToken(token);

        assertEquals(expected.getFirstName(), u.getFirstName());

    }
}
