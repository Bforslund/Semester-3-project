package individual.project.controllers;

import individual.project.repository.FakeOrdersRespository;

import individual.project.model.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class StatisticsControllerTest
{

    FakeOrdersRespository ordersRepository = new FakeOrdersRespository();
    StatisticsController scontroller = new StatisticsController(ordersRepository);


    @Test
    void testAmountOfCakes() {
       int total = scontroller.getTotalAmountOfCakesSold();
        assertEquals(3, total);
    }
    @Test
     void testAmountOfCupcakes() {
        int total = scontroller.getTotalAmountOfCupcakesSold();
        assertEquals(3, total);
    }
    @Test
     void testAmountOfCookies() {
        int total = scontroller.getTotalAmountOfCookiesSold();
        assertEquals(2, total);
    }
    @Test
     void testAmountOfOther() {
        int total = scontroller.getTotalAmountOfOtherSold();
        assertEquals(4, total);
    }
    @Test
     void testAmountOfOrdersofNow() {
        LocalDate now = LocalDate.now();
        Month monthNow = now.getMonth();

        List<StatisticsOrder> orders = scontroller.getOrderPerMonth();
        StatisticsOrder sO = null;
        for (StatisticsOrder o: orders) {
            if(o.getMonth().equals(monthNow.toString())){
                sO = o;
            }
        }
        int total = sO.getTotalOrders();
        assertEquals(4, total);
    }
    @Test
     void testGetTotalRevenue() {
        double total = scontroller.getTotalRevenue();
        assertEquals(400,total);
    }


}