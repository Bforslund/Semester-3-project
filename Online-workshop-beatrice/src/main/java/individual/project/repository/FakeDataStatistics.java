package individual.project.repository;
import individual.project.model.Item;
import individual.project.model.Order;
import individual.project.model.OrderItem;
import individual.project.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FakeDataStatistics {
    private final List<Item> itemsList = new ArrayList<>();
    private final List<Order> orderList = new ArrayList<>();
    private final List<User> userList = new ArrayList<>();

    private static int idSeeder = 5;

    public FakeDataStatistics(){

        // work this out better, add few more countries and students
        Item i1 = new Item(1, "Cake", 50, 100,"Flour", Item.TypeOfItem.CAKE);
        Item i2 = new Item(2,"sadsda", 50, 100,"Flour", Item.TypeOfItem.COOKIE);
        itemsList.add(i1);
        itemsList.add(i2);
        itemsList.add((new Item(3, "bfdgd", 50, 100,"Flour", Item.TypeOfItem.OTHER)));

        Order o1 = new Order(1,  1,"kuk", "Frida framstedt");
        Order o2 = new Order(2,1,"kuk", "Frida framstedt");
        Order o3 = new Order(3, 1,"kuk", "Frida framstedt");
        Order o4 = new Order(4, 1,"kuk", "Frida framstedt");
        orderList.add(o1);
        orderList.add(o2);
        orderList.add(o3);
        orderList.add(o4);

        OrderItem oi1 = new OrderItem(1, i2, 2);

        o1.AddItemToList(oi1);

        orderList.add((new Order(5, 1, "kuk", "Linda framstedt")));



        userList.add((new User(1, "Bea", "forslund", "Meijhorst", 400, "1999, 10, 21", "nothing", "kkkk@live.se", "121221")));
        userList.add((new User(2, "Bssfdfsdfea", "test","Meijhorst", 400, "1999, 10, 21", "nothing", "kkkk@live.se", "121221")));
    }

    public double GetTotalRevenue(){
        double total = 0;
        for (Order o:orderList) {
          total += o.getTotalPrice();
        }
        return total;
    }
    public int GetTotalAmountOfCakesSold(){
        return 0;
    }
    public int GetTotalAmountOfCupcakesSold(){
        return 0;
    }
    public int GetTotalAmountOfCookiesSold(){
        return 0;
    }
    public int GetTotalAmountOfOtherSold(){
        return 0;
    }
    //int month = localDate.getMonthValue();
    public int SalesPerMonth(){ // how much u sold, users
        return 0;
    }
    public int OrdersPerMonth(){ // how many orders
        return 0;
    }
    public int AveragePricePerOrder(){ // how many orders
        return 0;
    }
    public int GetAmountOfCustomersPerMonth(){
        return 0;
    }
    public int GetMostSoldItem(){
        return 0;
    }
}
