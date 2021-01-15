package individual.project.resources;

import individual.project.controllers.ItemController;
import individual.project.controllers.OrderController;
import individual.project.model.Item;
import individual.project.model.Order;
import individual.project.model.OrderItem;
import individual.project.model.User;
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
public class OrderResourcesTest {
    @InjectMocks
    OrderResources resources;

    @Mock
    OrderController controller;

    @Test
    void testGettingAnOrder()  {
        when(controller.getOrderById(1)).thenReturn(new Order());
        Response response = resources.getOrderById(1);

        Assertions.assertEquals(response.getStatus(), 200);
    }
    @Test
    public void getAllOrders()  {
        when(controller.showAllOrders()).thenReturn(
                Arrays.asList(
                       new Order()
                )
        );

        Response response = resources.getAllOrders();

        Assertions.assertEquals(response.getStatus(), 200);
    }
    @Test
    public void getAllOrderItems()  {
        when(controller.showAllOrderItems(1)).thenReturn(
                Arrays.asList(
                        new OrderItem()
                )
        );

        Response response = resources.getAllOrderItems(1);

        Assertions.assertEquals(response.getStatus(), 200);
    }
    @Test
    void testGettingAnOrderFromUser()  {
        when(controller.getUserByOrder(1)).thenReturn(new User());
        Response response = resources.getUserByOrderId(1);

        Assertions.assertEquals(response.getStatus(), 200);
    }
    @Test
    public void createOrder() {
       Order o = new Order();
        when(controller.addOrder(o)).thenReturn(o);

        Response response = resources.createOrder(o);

        assertEquals(response.getStatus(), 200);
    }
    @Test
    public void updateOrder() {
        Order o = new Order();
        when(controller.updateOrder(o)).thenReturn(true);

        Response response = resources.updateOrder(o);

        assertEquals(response.getStatus(), 204);
    }
    @Test
    public void deleteOrder() {

        when(controller.deleteAll()).thenReturn(true);

        Response response = resources.deleteAllOrders();

        assertEquals(response.getStatus(), 204);
    }
    @Test
    public void getAllOrdersOfUser()  {
        when(controller.showAllOrdersOfOneUser(1)).thenReturn(
                Arrays.asList(
                        new Order()
                )
        );

        Response response = resources.getAllOrdersOfUser(1);

        Assertions.assertEquals(response.getStatus(), 200);
    }
}
