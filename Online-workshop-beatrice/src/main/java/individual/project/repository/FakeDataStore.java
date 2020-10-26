package individual.project.repository;

import individual.project.model.Item;
import individual.project.model.Order;
import individual.project.model.OrderItem;
import individual.project.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FakeDataStore {

// Maybe I should use inheritance to make it one list?
    private final List<Item> itemsList = new ArrayList<>();
    private final List<Order> orderList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    private final List<User> userList = new ArrayList<>();

    private static int idSeeder = 5;


    public FakeDataStore() {

        // work this out better, add few more countries and students
        Item i1 = new Item(1, "Cake", 50, 100,"Flour", Item.TypeOfItem.CAKE);
        Item i2 = new Item(2,"sadsda", 50, 100,"Flour", Item.TypeOfItem.COOKIE);
        itemsList.add(i1);
        itemsList.add(i2);
        itemsList.add((new Item(3, "bfdgd", 50, 100,"Flour", Item.TypeOfItem.OTHER)));

        Order o1 = new Order(1,  1,"kuk", "Frida framstedt");
        orderList.add(o1);

        OrderItem oi1 = new OrderItem(1, i2, 2);

        o1.AddItemToList(oi1);

        orderList.add((new Order(2, 1, "kuk", "Linda framstedt")));



        userList.add((new User(1, "Bea", "forslund", "Meijhorst", 400, "1999, 10, 21", "nothing", "kkkk@live.se", "121221")));
        userList.add((new User(2, "Bssfdfsdfea", "test","Meijhorst", 400, "1999, 10, 21", "nothing", "kkkk@live.se", "121221")));
    }


    public List<Item> GetItems() { return itemsList;}
    public List<Order> GetOrders() { return orderList;}

    public boolean addItem(Item item) {
        item.setId(idSeeder);
        itemsList.add(item);
        idSeeder++;
        return true;
    }
    public boolean addOrder(Order order) {
//
//         if (this.getStudent(student.getStudentNumber()) != null){
//                       return false;
//               }
        orderList.add(order);
        return true;
    }
    public boolean addUser(User user) {
        if (this.getUserEmail(user.getEmail()) != null){
                       return false;
                }
        userList.add(user);
        return true;
    }


    public Item getItem(int nr) {
        for (Item i : itemsList) {
            if (i.getId() == nr)
                return i;
        }
        return null;
    }
    public User getUserEmail(String email) {
        for (User u : userList) {
            if (u.getEmail().equals(email))
                return u;
        }
        return null;
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

    public boolean updateItem(Item item) {
        Item old = this.getItem(item.getId());
        if (old == null) {
            return false;
        }
        old.setName(item.getName());
        old.setIngredients(item.getIngredients());
        old.setBuyingPrice(item.getBuyingPrice());
        old.setSellingPrice(item.getSellingPrice());
        old.setType(item.getType());
        return true;
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

    public boolean updateUser(User user) {
        updateUser(user, user.getId());

        return true;
    }
    public boolean updateUser(User user, int id) {
        User old = this.getUser(id);
        if (old == null) {
            return false;
        }
        old.setAddress(user.getAddress());
        old.setBirthday(user.getBirthday());
        old.setLastName(user.getLastName());
        old.setFirstName(user.getFirstName());
        old.setOrderHistory(user.getOrderHistory());
        old.setPoints(user.getPoints());
        old.setEmail(user.getEmail());
        old.setPassword(user.getPassword());

        return true;
    }

    public boolean deleteItem(int id) {
        Item i = getItem(id);
        if (i == null){
            return false;
        }
        return itemsList.remove(i);
    }

    public void deleteAllOrder() {
        orderList.clear();
    }

    public boolean deleteUser(int id) {
    User u = getUser(id);
        if (u == null){
            return false;
        }
        return userList.remove(u);
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
