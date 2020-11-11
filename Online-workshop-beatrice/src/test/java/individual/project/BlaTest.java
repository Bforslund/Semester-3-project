package individual.project;

import individual.project.controllers.ItemController;
import individual.project.controllers.OrderController;
import individual.project.controllers.StatisticsController;
import individual.project.controllers.UserController;
import individual.project.model.*;
import org.hibernate.stat.Statistics;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple Dep.
 */
public class BlaTest
{
    OrderController persistenceController = new OrderController();
    ItemController controller = new ItemController();
    UserController ucontroller = new UserController();
    StatisticsController scontroller = new StatisticsController();

//    User user1 = new User("Bea", "forslund", "Meijhorst", 400, "1999, 10, 21",  "kkkk@live.se", "121221");
////        Item i1 = new Item( "Cake", 50, 100,"Flour", Item.TypeOfItem.CAKE);
////        Item i2 = new Item("sadsda", 50, 100,"Flour", Item.TypeOfItem.COOKIE);
////        Item i3 = new Item( "bfdgd", 50, 100,"Flour", Item.TypeOfItem.OTHER);
//
//    Item i2 = controller.getItemById(2);
//    Item i3 = controller.getItemById(7);
//    Order o1 = new Order(  1,"kuk", "Frida framstedt");
//
//    OrderItem oi1 = new OrderItem(i2, 3);
//    OrderItem oi2 = new OrderItem(i3, 2);
//
//        o1.AddItemToList(oi1);
//        o1.AddItemToList(oi2);
//        persistenceController.addOrder(o1);


    @Test
    public void testHowManyOrderIHave()
    {

        List<Order> orders = persistenceController.showAllOrders();
        int count = orders.size();
        assertEquals(count, 3);

    }
    @Test
    public void testHowManyItemsOneOrderHas()
    {

       Order o = persistenceController.getOrderById(1);
       int count = o.getOrderedItemsList().size();
        assertEquals(count, 2);
    }
    @Test
    public void testGettingAnItemFromId()
    {
        Item cake = controller.getItemById(1);
        String name = cake.getName();
        assertEquals(name, "Chocolate cake");
    }
    @Test
    public void testAddItemsToOrder()
    {
        Order o = persistenceController.getOrderById(3);
        Item cake = controller.getItemById(1);
        OrderItem o1 = new OrderItem(cake, 1);
        o.AddItemToList(o1);

        int count = o.getOrderedItemsList().size();
        assertEquals(count, 3);
    }
    @Test
    public void testAmountOfCakes() {
       int total = scontroller.GetTotalAmountOfCakesSold();
        assertEquals(total, 6);
    }
    @Test
    public void testAmountOfOrdersInOctober() {
        List<StatisticsOrder> orders = scontroller.GetOrderPerMonth();
        StatisticsOrder sO = null;
        for (StatisticsOrder o: orders) {
            if(o.getMonth().equals("oct")){
                sO = o;
            }
        }
        int total = sO.getTotalOrders();
        assertEquals(total, 1);
    }
// wrong test cases, seperate them

}