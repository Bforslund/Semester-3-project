package individual.project;
import individual.project.Repositories.FakeOrdersRespository;
import individual.project.controllers.ItemController;
import individual.project.controllers.OrderController;
import individual.project.controllers.StatisticsController;
import individual.project.controllers.UserController;
import individual.project.model.*;
import individual.project.repository.IOrdersRepository;
import org.hibernate.stat.Statistics;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class OrderTest {
    //    @Rule
//    public ExpectedException exception = ExpectedException.none();

    FakeOrdersRespository ordersRepository = new FakeOrdersRespository();

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
