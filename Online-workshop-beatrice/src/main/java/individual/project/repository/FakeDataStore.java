package individual.project.repository;

import individual.project.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FakeDataStore {

    private final List<Item> itemsList = new ArrayList<>();
    private final List<Order> orderList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    private final List<User> userList = new ArrayList<>();

    public FakeDataStore() {

        // work this out better, add few more countries and students
//        Item i1 = new Item(1, "Cake", 50, 100,"Flour", Item.TypeOfItem.CAKE);
//        Item i2 = new Item(2,"sadsda", 50, 100,"Flour", Item.TypeOfItem.COOKIE);
//        itemsList.add(i1);
//        itemsList.add(i2);
//        itemsList.add((new Item(3, "bfdgd", 50, 100,"Flour", Item.TypeOfItem.OTHER)));

//        Order o1 = new Order(1,  1,"kuk", "Frida framstedt");
//        orderList.add(o1);
//
////        OrderItem oi1 = new OrderItem(1, 1, 1, 2);
//
////        o1.AddItemToList(oi1);
//
//        orderList.add((new Order(2, 1, "kuk", "Linda framstedt")));


//
//        userList.add((new User(1, "Bea", "forslund", "Meijhorst", 400, "1999, 10, 21",  "kkkk@live.se", "121221")));
//        userList.add((new User(2, "Bssfdfsdfea", "test","Meijhorst", 400, "1999, 10, 21", "kkkk@live.se", "121221")));
    }


    public List<Order> GetOrders() { return orderList;}


    public boolean addOrder(Order order) {
        orderList.add(order);
        return true;
    }

    public User getUser(int nr) {
        for (User u : userList) {
            if (u.getId() == nr)
                return u;
        }
        return null;
    }
    public Order getOrder(int nr) {
        for (Order o : orderList) {
            if (o.getOrderNumber() == nr)
                return o;
        }
        return null;
    }
    public User getUserFromOrderId(int nr) {
        Order order = getOrder(nr);
        User u = getUser(order.getUserId());
        return u;
    }

    public List<OrderItem> getAllOrderItems(int orderNumber) {
        Order order = getOrder(orderNumber);

      return order.getOrderedItemsList();
    }



    public boolean updateOrder(Order order) {
        Order old = this.getOrder(order.getOrderNumber());
        if (old == null) {
            return false;
        }
        old.setStatus(order.getStatus());
        old.setAddress(order.getAddress());
        return true;
    }

    public void deleteAllOrder() {
        orderList.clear();
    }


    public List<Order> GetAllOrdersOfUser(int Userid){
      List<Order> AllOrders = new ArrayList<>();

        for (Order o:orderList) {
            if(o.getUserId() == Userid){
                AllOrders.add(o);
            }
        }
        return AllOrders;
    }


}
