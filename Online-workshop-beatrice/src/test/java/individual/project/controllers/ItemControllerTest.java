package individual.project.controllers;
import individual.project.repository.FakeItemsRepository;
import individual.project.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ItemControllerTest {
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
