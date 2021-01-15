package individual.project.resources;

import individual.project.controllers.ItemController;
import individual.project.model.Item;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.ws.rs.core.Response;
import java.util.Arrays;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ItemResourcesTest  {

    @InjectMocks
    ItemResources itemResources;

    @Mock
    ItemController itemController;



    @Test
    void testGettingAnItem()  {
        when(itemController.getItemById(1)).thenReturn(new Item(1,"cake", 5,2, "flour", Item.TypeOfItem.COOKIE));
        Response response = itemResources.getItemById(1);
        //Item i = response.readEntity(Item.class);

        Assertions.assertEquals(response.getStatus(), 200);
    }
    @Test
    public void getAllItems()  {
        when(itemController.showAllItems()).thenReturn(
                Arrays.asList(
                       new Item( 1,"Cake", 50, 5,"Flour", Item.TypeOfItem.CAKE),
       new Item(2,"Cookie", 70, 5,"Flour", Item.TypeOfItem.COOKIE),
        new Item(3, "Strass", 30, 5,"Flour", Item.TypeOfItem.OTHER),
       new Item(4,"Cupcake", 10, 5,"Flour", Item.TypeOfItem.CUPCAKE),
         new Item(5,"Cupcake", 10, 5,"Flour", Item.TypeOfItem.CUPCAKE)
                )
        );

        Response response = itemResources.getAllItems();

        Assertions.assertEquals(response.getStatus(), 200);
    }
    @Test
    public void createItem() {
        Item newItem =  new Item(4,"Cupcake", 10, 5,"Flour", Item.TypeOfItem.CUPCAKE);

        when(itemController.addItem(newItem)).thenReturn(true);

        Response response = itemResources.createItem(newItem);

        assertEquals(response.getStatus(), 201);
    }
    @Test
    public void updateItem() {
        Item newItem =  new Item(4,"Cupcake", 10, 5,"Flour", Item.TypeOfItem.CUPCAKE);

        when(itemController.UpdateItem(newItem)).thenReturn(true);

        Response response = itemResources.updateItem(newItem);

        assertEquals(response.getStatus(), 204);
    }
    @Test
    public void deleteItem() {
        Item newItem =  new Item(4,"Cupcake", 10, 5,"Flour", Item.TypeOfItem.CUPCAKE);

        when(itemController.DeleteItem(4)).thenReturn(true);

        Response response = itemResources.deleteItem(4);

        assertEquals(response.getStatus(), 204);
    }


}
