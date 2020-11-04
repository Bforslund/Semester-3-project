package individual.project.controllers;
import individual.project.model.*;
import individual.project.repository.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StatisticsController {
    HibernateItemsRepository itemsRepository = new HibernateItemsRepository();
    HibernateOrdersRepository ordersRepository = new HibernateOrdersRepository();

    public double GetTotalRevenue(){
        try {
            double total = 0;
            List<Order> orderList = ordersRepository.getOrders();
            for (Order o : orderList) {
                total += o.getTotalPrice();
            }
            return total;
        }catch(Exception e){
            return 0;
        }
    }
    public int GetTotalAmountOfCakesSold(){
        try{
        int total = 0;
        List<Order> orderList = ordersRepository.getOrders();
        for (Order o:orderList) {
            for(OrderItem oi:o.getOrderedItemsList()){
                Item i = oi.getItem();
                if(i.getType().equals(Item.TypeOfItem.CAKE)){
                    total += oi.getQuantity();
                }
            }

        }
        return total;
    }catch(Exception e){
        return 0;
    }
    }
    public int GetTotalAmountOfCupcakesSold(){
        try{
            int total = 0;
            List<Order> orderList = ordersRepository.getOrders();
            for (Order o:orderList) {
                for(OrderItem oi:o.getOrderedItemsList()){
                    Item i = oi.getItem();
                    if(i.getType().equals(Item.TypeOfItem.CUPCAKE)){
                        total += oi.getQuantity();
                    }
                }

            }
            return total;
        }catch(Exception e){
            return 0;
        }
    }
    public int GetTotalAmountOfCookiesSold(){
        try{
            int total = 0;
            List<Order> orderList = ordersRepository.getOrders();
            for (Order o:orderList) {
                for(OrderItem oi:o.getOrderedItemsList()){
                    Item i = oi.getItem();
                    if(i.getType().equals(Item.TypeOfItem.COOKIE)){
                        total += oi.getQuantity();
                    }
                }

            }
            return total;
        }catch(Exception e){
            return 0;
        }
    }
    public int GetTotalAmountOfOtherSold(){
        try{
            int total = 0;
            List<Order> orderList = ordersRepository.getOrders();
            for (Order o:orderList) {
                for(OrderItem oi:o.getOrderedItemsList()){
                    Item i = oi.getItem();
                    if(i.getType().equals(Item.TypeOfItem.OTHER)){
                        total += oi.getQuantity();
                    }
                }

            }
            return total;
        }catch(Exception e){
            return 0;
        }
    }
    //int month = localDate.getMonthValue();
    public int SalesPerMonth(){ // how much u sold, users
        return 0;
    }

    public int GetMostSoldItem(){
        return 0;
    }
    public List<StatisticsOrder> GetOrderPerMonth() {
        try {
            List<Integer> allMonths = new ArrayList<>();
            List<Order> orderList = ordersRepository.getOrders();
            for (Order o : orderList) {
                LocalDate time = o.getTime();
                allMonths.add(time.getMonthValue());

            }


            StatisticsOrder jan = new StatisticsOrder("jan", 0);
            StatisticsOrder feb = new StatisticsOrder("feb", 0);
            StatisticsOrder mar = new StatisticsOrder("mar", 0);
            StatisticsOrder apr = new StatisticsOrder("apr", 0);
            StatisticsOrder may = new StatisticsOrder("may", 0);
            StatisticsOrder jun = new StatisticsOrder("jun", 0);
            StatisticsOrder jul = new StatisticsOrder("jul", 0);
            StatisticsOrder aug = new StatisticsOrder("aug", 0);
            StatisticsOrder sep = new StatisticsOrder("sep", 0);
            StatisticsOrder oct = new StatisticsOrder("oct", 0);
            StatisticsOrder nov = new StatisticsOrder("nov", 0);
            StatisticsOrder dec = new StatisticsOrder("dec", 0);
            List<StatisticsOrder> StatList = new ArrayList<>();

            for (Integer m: allMonths) {
                switch (m) {
                    case 1:
                        int i = jan.getTotalOrders();
                        i++;
                        jan.setTotalOrders(i);
                        break;
                    case 2:
                        i = feb.getTotalOrders();
                        i++;
                        feb.setTotalOrders(i);
                        break;
                    case 3:
                        i = mar.getTotalOrders();
                        i++;
                        mar.setTotalOrders(i);
                        break;
                    case 4:
                        i = apr.getTotalOrders();
                        i++;
                        apr.setTotalOrders(i);
                        break;
                    case 5:
                        i = may.getTotalOrders();
                        i++;
                        may.setTotalOrders(i);
                        break;
                    case 6:
                        i = jun.getTotalOrders();
                        i++;
                        jun.setTotalOrders(i);
                        break;
                    case 7:
                        i = jul.getTotalOrders();
                        i++;
                        jul.setTotalOrders(i);
                        break;
                    case 8:
                        i = aug.getTotalOrders();
                        i++;
                        aug.setTotalOrders(i);
                        break;
                    case 9:
                        i = sep.getTotalOrders();
                        i++;
                        sep.setTotalOrders(i);
                        break;
                        case 10:
                        i = oct.getTotalOrders();
                        i++;
                        oct.setTotalOrders(i);
                        break;
                    case 11:
                        i = nov.getTotalOrders();
                        i++;
                        nov.setTotalOrders(i);
                        break;
                    case 12:
                        i = dec.getTotalOrders();
                        i++;
                        dec.setTotalOrders(i);
                        break;

                }
            }

            StatList.add(jan);
            StatList.add(feb);
            StatList.add(mar);
            StatList.add(apr);
            StatList.add(may);
            StatList.add(jun);
            StatList.add(jul);
            StatList.add(aug);
            StatList.add(sep);
            StatList.add(oct);
            StatList.add(nov);
            StatList.add(dec);
            return StatList;

        } catch (Exception e) {
            return null;
        }
    }
}
