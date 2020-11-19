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


public class StatisticsTest
{

//    @Rule
//    public ExpectedException exception = ExpectedException.none();

    FakeOrdersRespository ordersRepository = new FakeOrdersRespository();
    StatisticsController scontroller = new StatisticsController(ordersRepository);


    @Test
    public void testAmountOfCakes() {
       int total = scontroller.GetTotalAmountOfCakesSold();
        assertEquals(total, 3);
    }
    @Test
    public void testAmountOfCupcakes() {
        int total = scontroller.GetTotalAmountOfCupcakesSold();
        assertEquals(total, 3);
    }
    @Test
    public void testAmountOfCookies() {
        int total = scontroller.GetTotalAmountOfCookiesSold();
        assertEquals(total, 2);
    }
    @Test
    public void testAmountOfOther() {
        int total = scontroller.GetTotalAmountOfOtherSold();
        assertEquals(total, 4);
    }
    @Test
    public void testAmountOfOrdersofNow() {
        LocalDate now = LocalDate.now();
        Month monthNow = now.getMonth();

        List<StatisticsOrder> orders = scontroller.GetOrderPerMonth();
        StatisticsOrder sO = null;
        for (StatisticsOrder o: orders) {
            if(o.getMonth().equals(monthNow.toString())){
                sO = o;
            }
        }
        int total = sO.getTotalOrders();
        assertEquals(total, 4);
    }
    @Test
    public void testGetTotalRevenue() {
        double total = scontroller.GetTotalRevenue();
        assertEquals(total, 600);
    }

//    @Test(expected = IndexOutOfBoundsException.class)
//    public void testFakeRevenue() {
//        int total = scontroller.GetTotalAmountOfCakesSold();
//
//    }


}