package individual.project.repository;

import individual.project.model.Item;
import individual.project.model.Order;
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

    public FakeDataStore() {
        // work this out better, add few more countries and students

        itemsList.add((new Item(1, "Cake", 50, "Flour", "Cakeycake")));
        itemsList.add((new Item(2, "sadsda", 50, "Flour", "Cakeycake")));
        itemsList.add((new Item(3, "bfdgd", 50, "Flour", "Cakeycake")));

        orderList.add((new Order(1, 100, 1, "kuk")));
        orderList.add((new Order(2, 100, 1, "kuk")));

        userList.add((new User(1, "Bea", "Meijhorst", 400, LocalDate.of(1999, 10, 21), "nothing", "kkkk@live.se", "121221")));
        userList.add((new User(2, "Bssfdfsdfea", "Meijhorst", 400, LocalDate.of(1999, 10, 21), "nothing", "kkkk@live.se", "121221")));
    }


    public List<Item> GetItems() { return itemsList;}
    public List<Order> GetOrders() { return orderList;}

    public boolean addItem(Item item) {
            itemsList.add(item);
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
            if (u.getEmail() == email)
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
    public boolean updateItem(Item item) {
        Item old = this.getItem(item.getId());
        if (old == null) {
            return false;
        }
        old.setName(item.getName());
        old.setIngredients(item.getIngredients());
        old.setPrice(item.getPrice());
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
        User old = this.getUser(user.getId());
        if (old == null) {
            return false;
        }
        old.setAddress(user.getAddress());
        old.setBirthday(user.getBirthday());
        old.setName(user.getName());
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


}
