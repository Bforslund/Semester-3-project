package individual.project.resources;

import individual.project.controllers.ItemController;
import individual.project.controllers.StatisticsController;
import individual.project.model.Item;
import individual.project.model.StatisticsOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.core.Response;
import java.util.Arrays;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticsResourcesTest {
    @InjectMocks
    StatisticsResources resources;

    @Mock
    StatisticsController controller;
    @Test
    public void getTotalRevenue()  {
        when(controller.getTotalRevenue()).thenReturn(100.0);

        Response response = resources.getTotalRevenue();

        Assertions.assertEquals(response.getStatus(), 200);
    }
    @Test
    public void getTotalCakesSold()  {
        when(controller.getTotalAmountOfCakesSold()).thenReturn(100);

        Response response = resources.getTotalCakesSold();

        Assertions.assertEquals(response.getStatus(), 200);
    }
    @Test
    public void getTotalCookiesSold()  {
        when(controller.getTotalAmountOfCookiesSold()).thenReturn(100);

        Response response = resources.getTotalCookiesSold();

        Assertions.assertEquals(response.getStatus(), 200);
    }
    @Test
    public void getTotalCupcakesSold()  {
        when(controller.getTotalAmountOfCupcakesSold()).thenReturn(100);

        Response response = resources.getTotalCupcakesSold();

        Assertions.assertEquals(response.getStatus(), 200);
    }
    @Test
    public void getTotalOtherSold()  {
        when(controller.getTotalAmountOfOtherSold()).thenReturn(100);

        Response response = resources.getTotalOtherSold();

        Assertions.assertEquals(response.getStatus(), 200);
    }
    @Test
    public void getTotalOrderPerMonthSold()  {
        when(controller.getOrderPerMonth()).thenReturn(
                Arrays.asList(
                      new StatisticsOrder("october", 5)
                )
        );

        Response response = resources.getAllItems();

        Assertions.assertEquals(response.getStatus(), 200);
    }
}
