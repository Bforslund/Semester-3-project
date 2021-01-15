package individual.project.controllers;

import individual.project.model.*;

import individual.project.repository.FakeOrdersRespository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class OrderControllerTest {

    OrderController controller = new OrderController(new FakeOrdersRespository());

    @Test
     void testAddItemsToOrder()
    {
        Order o = new Order();
        Item i1 = new Item( "Cake", 50, 100,"Flour", Item.TypeOfItem.CAKE);
        OrderItem oi1 = new OrderItem(i1, 70);

        o.addItemToList(oi1);

        int count = o.getOrderedItemsList().size();
        assertEquals(count, 1);
    }
    @Test
    void testGetTotalPriceOfOrder()
    {
        Order o = new Order(1, "address", "Anna", 3500, new ArrayList<>());

        Item i1 = new Item( "Cake", 50, 100,"Flour", Item.TypeOfItem.CAKE);

        OrderItem oi1 = new OrderItem(i1, 70);
        o.addItemToList(oi1);

        double count = o.getTotalPrice();
        assertEquals(count, 3500);
    }
    @Test
    void showAllOrdersItems()
    {
        Order o = new Order(1, "address", "Anna", 3500, new ArrayList<>());
        Item i1 = new Item( "Cake", 50, 100,"Flour", Item.TypeOfItem.CAKE);
        OrderItem oi1 = new OrderItem(i1, 2);
        OrderItem oi5 = new OrderItem(i1, 1);
        o.addItemToList(oi1);
        o.addItemToList(oi5);

        List<OrderItem> orderitems = controller.showAllOrderItems(1);
        assertEquals(orderitems.size(), o.getOrderedItemsList().size());
    }
    @Test
    void addAnOrder()
    {
        Order o = new Order(1, "address", "Anna", 3500, new ArrayList<>());
        Item i1 = new Item( "Cake", 50, 100,"Flour", Item.TypeOfItem.CAKE);
        OrderItem oi1 = new OrderItem(i1, 2);
        o.addItemToList(oi1);
       controller.addOrder(o);

      List<Order> orders = controller.showAllOrders();

        assertEquals(orders.size(), 5);
    }



}
