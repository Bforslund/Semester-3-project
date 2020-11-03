package individual.project;

import individual.project.controllers.*;
import individual.project.model.*;

import java.util.List;

public class PersistenceMain {

    public static void main(String[] args) {

        OrderController persistenceController = new OrderController();
        ItemController controller = new ItemController();
        UserController ucontroller = new UserController();
       User user1 = new User("Bea", "forslund", "Meijhorst", 400, "1999, 10, 21",  "kkkk@live.se", "121221");

      // controller.UpdateItem();
    }


}
