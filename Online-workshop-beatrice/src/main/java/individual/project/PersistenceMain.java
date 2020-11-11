package individual.project;

import individual.project.controllers.*;
import individual.project.model.*;

import java.util.ArrayList;
import java.util.List;

public class PersistenceMain {

    public static void main(String[] args) {

        OrderController persistenceController = new OrderController();
        ItemController controller = new ItemController();
        UserController ucontroller = new UserController();
        StatisticsController scontroller = new StatisticsController();
       User user1 = new User("Bea", "forslund", "Meijhorst", 400, "1999, 10, 21",  "kkkk@live.se", "121221");
//        Item i1 = new Item( "Cake", 50, 100,"Flour", Item.TypeOfItem.CAKE);
//        Item i2 = new Item("sadsda", 50, 100,"Flour", Item.TypeOfItem.COOKIE);
//        Item i3 = new Item( "bfdgd", 50, 100,"Flour", Item.TypeOfItem.OTHER);

     User u2 =  ucontroller.getUserByEmail("test@live.se");
//        Item i2 = controller.getItemById(2);
//        Item i3 = controller.getItemById(7);
//        Order o1 = new Order(  1,"kuk", "Frida framstedt");
//
//        OrderItem oi1 = new OrderItem(i2, 3);
//        OrderItem oi2 = new OrderItem(i3, 2);
//
//        o1.AddItemToList(oi1);
//        o1.AddItemToList(oi2);
//        persistenceController.addOrder(o1);

        // controller.UpdateItem();

    }


}
