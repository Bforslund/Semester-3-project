package individual.project;
import individual.project.Repositories.FakeOrdersRespository;

import individual.project.model.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class OrderTest {
    //    @Rule
//    public ExpectedException exception = ExpectedException.none();


    @Test
    public void testAddItemsToOrder()
    {
        Order o = new Order(1, "address", "name");
        Item i1 = new Item( "Cake", 50, 100,"Flour", Item.TypeOfItem.CAKE);
        OrderItem oi1 = new OrderItem(i1, 70);

        o.AddItemToList(oi1);

        int count = o.getOrderedItemsList().size();
        assertEquals(count, 1);
    }
    @Test
    public void testGetTotalPriceOfOrder()
    {
        Order o = new Order(1, "address", "name");
        Item i1 = new Item( "Cake", 50, 100,"Flour", Item.TypeOfItem.CAKE);
        OrderItem oi1 = new OrderItem(i1, 70);
        o.AddItemToList(oi1);

        double count = o.getTotalPrice();
        assertEquals(count, 3500);
    }


}
