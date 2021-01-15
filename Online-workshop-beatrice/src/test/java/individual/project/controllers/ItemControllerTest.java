package individual.project.ControllerTests;
import individual.project.Repositories.FakeItemsRepository;
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

public class ItemTest {
    FakeItemsRepository repository = new FakeItemsRepository();
    ItemController controller = new ItemController(repository);
    @Test
     void testSearchItem()
    {
       List<Item> foundItems = controller.search("c");
       int count = foundItems.size();
        assertEquals(count, 4);
    }
    @Test
     void testFilterByTypeItem()
    {
        List<Item> foundItems = controller.filterByType(Item.TypeOfItem.COOKIE, 0);
        int count = foundItems.size();
        assertEquals(count, 1);
    }
    @Test
   void testFilterByPriceItem()
    {
        List<Item> foundItems = controller.filterByType(null, 100);
        int count = foundItems.size();
        assertEquals(count, 5);
    }
    @Test
     void testFilterByTypeAndPriceItem()
    {
        List<Item> foundItems = controller.filterByType(Item.TypeOfItem.CUPCAKE, 100);
        int count = foundItems.size();
        assertEquals(count, 2);
    }
}
