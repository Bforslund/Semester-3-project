package individual.project.ControllerTests;

import individual.project.model.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class OrderTest {
    //    @Rule
//    public ExpectedException exception = ExpectedException.none();


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


}
