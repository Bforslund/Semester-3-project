package individual.project.model;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class UserTest {
    @Test //check whether user info are correct
    void NewUserTest()
    {

        User u = new User("Beatrice", "Forslund", "Nijmegen", "1999-10-21", "Bea@gmail.com", "1234");


        assertEquals("Beatrice", u.getFirstName());
        assertEquals("Forslund", u.getLastName());
        assertEquals("Nijmegen", u.getAddress());
        assertEquals("1999-10-21", u.getBirthday());
        assertEquals("Bea@gmail.com", u.getEmail());
        assertEquals("1234", u.getPassword());

    }

    @Rule // this rule is added to throw exceptions when its needed
    ExpectedException thrown = ExpectedException.none();

    @Test // user first name null
    void getUserFirstNameWithNullValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        User u= new User();
        u.setFirstName(null);
        });
    }

    @Test // user first name string is empty
    void getUserFirstNameWithEmptyValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        User u= new User();
        u.setFirstName("");
        });
    }

    @Test // user last name null
    void getUserLastNameWithNullValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            User u= new User();
            u.setLastName(null);
        });
    }

    @Test // user last name string is empty
    void getUserLastNameWithEmptyValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        User u= new User();
        u.setLastName("");
        });
    }

    @Test // user email null
    void getUserEmailWithNullValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        User u= new User();
        u.setEmail(null);
        });
    }

    @Test // user email string is empty
    void getUserEmailWithEmptyValue() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
        User u= new User();
        u.setEmail("");
            });
    }

    @Test // user password null
    void getUserPasswordWithNullValue() {
                Assertions.assertThrows(IllegalArgumentException.class, () -> {
        User u= new User();
        u.setPassword(null);
                });
    }

    @Test // user password string is empty
    void getUserPasswordWithEmptyValue() {
                    Assertions.assertThrows(IllegalArgumentException.class, () -> {
        User u= new User();
        u.setPassword("");
                    });
    }

    @Test
    void getAddressWithNullValue() {
                        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        User u= new User();
        u.setAddress(null);
                        });
    }

    @Test
    void getUserBdayWithNullValue() {
                            Assertions.assertThrows(IllegalArgumentException.class, () -> {
        User u= new User();
        u.setBirthday(null);
                            });
    }


}
