package individual.project.repository;

import individual.project.model.Item;
import individual.project.model.Order;
import individual.project.model.OrderItem;
import individual.project.model.User;

import java.util.ArrayList;
import java.util.List;

public class FakeOrdersRespository implements IOrdersRepository {
    List<Order> orderList = new ArrayList<>();
    public FakeOrdersRespository(){
        //    User user1 = new User("Bea", "forslund", "Meijhorst", 400, "1999, 10, 21",  "kkkk@live.se", "121221");
        Item i1 = new Item( "Cake", 50, 100,"Flour", Item.TypeOfItem.CAKE);
        Item i2 = new Item("Cookie", 50, 100,"Flour", Item.TypeOfItem.COOKIE);
        Item i3 = new Item( "Strass", 50, 100,"Flour", Item.TypeOfItem.OTHER);
        Item i4 = new Item("Cupcake", 50, 100,"Flour", Item.TypeOfItem.CUPCAKE);


        Order o1 = new Order(1,100,1, "kuk", "Johanna Ubrig");
        Order o2 = new Order(2,100,1,"Address 1", "Frida framstedt");
        Order o3 = new Order(3,100,1,"Address 2", "Lina Lund");
        Order o4 = new Order(4,100,1,"Address 3", "Amanda Kell");

        OrderItem oi1 = new OrderItem(i1, 2);
        OrderItem oi2 = new OrderItem(i2, 1);
        OrderItem oi3 = new OrderItem(i3, 4);
        OrderItem oi4 = new OrderItem(i4, 3);
        OrderItem oi5 = new OrderItem(i2, 1);
        OrderItem oi6 = new OrderItem(i1, 1);

        o1.addItemToList(oi1);
        o2.addItemToList(oi2);
        o3.addItemToList(oi3);
        o4.addItemToList(oi4);
        o1.addItemToList(oi5);
        o2.addItemToList(oi6);

        orderList.add(o1);
        orderList.add(o2);
        orderList.add(o3);
        orderList.add(o4);

    }


    @Override
    public List<Order> getOrders() {
        return orderList;
    }

    @Override
    public List<Order> getAllOrderOfOneUser(int userId) {
        return null;
    }

    @Override
    public List<OrderItem> getOrderItems(int nr){
        Order o = getOrderById(nr);
     return o.getOrderedItemsList();
    }

    @Override
    public Order getOrderById(int orderNumber) {
        for (Order o:orderList) {
            if(o.getUserId() == orderNumber){
                return o;
            }

        }
        return null;
    }

    @Override
    public User getUserfromOrder(int orderNumber){
        return null;
    }

    @Override
    public void create(Order o)  {
        orderList.add(o);
    }

    @Override
    public void update(Order o)  {

    }

    @Override
    public void delete()  {

    }

    public void clearFake() {

    }
}
