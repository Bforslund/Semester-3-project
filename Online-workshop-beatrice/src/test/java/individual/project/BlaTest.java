package individual.project;

import individual.project.model.Item;
import individual.project.model.Order;
import individual.project.model.OrderItem;
import individual.project.repository.FakeDataStatistics;
import individual.project.repository.FakeDataStore;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple Dep.
 */
public class BlaTest
{
    /**
     * Rigourous Test :-)
     */
    @Test
    public void testDep()
    {
       FakeDataStore fk = new FakeDataStore();
        List<Order> orders = fk.GetOrders();
        int count = orders.size();
        assertEquals(count, 2);
    }
    @Test
    public void test2()
    {
        FakeDataStore fk = new FakeDataStore();
       Order o = fk.getOrder(1);
       int count = o.getOrderedItemsList().size();
        assertEquals(count, 1);
    }
    @Test
    public void test3()
    {
        FakeDataStore fk = new FakeDataStore();
        Order o = fk.getOrder(1);
        Item cake = new Item(1, "Chocolate cake", 50, 60, "Choclate", Item.TypeOfItem.CAKE);
        OrderItem o1 = new OrderItem(1, cake, 2);
        o.AddItemToList(o1);

        int count = o.getOrderedItemsList().size();
        assertEquals(count, 2);
    }
    @Test
    public void testAmountOfCakes()
    {
        FakeDataStatistics fk = new FakeDataStatistics();
       int total = fk.GetTotalAmountOfCakesSold();

        assertEquals(total, 2);
    }


}