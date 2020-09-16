package individual.project.repository;

import individual.project.model.Item;
import individual.project.model.Order;
import individual.project.model.User;

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

        itemsList.add((new Item(1, "Cake", 50, "Flour", "Cakeycake")));
    }


    public List<Item> GetItems() { return itemsList;}
    public List<Order> GetOrders() { return orderList;}

    public boolean addItem(Item item) {
//        for (Item i : itemsList)
//        {
//            if(i.getName() == item.getName()){
//                return false;
//            }
//        }
            itemsList.add(item);
        return true;
    }
    public boolean updateItem(Item item) {
        Item old = this.GetItems().get(item.getId());
        if (old == null) {
            return false;
        }
        old.setName(item.getName());
        old.setIngredients(item.getIngredients());
        old.setPrice(item.getPrice());
        old.setType(item.getType());
        return true;
    }


    public boolean deleteItem(Item item) {
        if (item == null){
            return false;
        }
        return itemsList.remove(item);
    }
    public boolean updateOrder(Order order) {
        Order old = this.GetOrders().get(order.getOrderNumber());
        if (old == null) {
            return false;
        }
        old.setStatus(order.getStatus());
        return true;
    }
    public void deleteAllOrder() {

        orderList.clear();
    }
    public boolean deleteUser(User user) {
        if (user == null){
            return false;
        }
        return userList.remove(user);
    }
    public boolean updateUser(User user) {
        User old = this.getUserList().get(user.getId());
        if (old == null) {
            return false;
        }
        old.setAddress(user.getAddress());
        old.setBirthday(user.getBirthday());
        old.setName(user.getName());
        old.setOrderHistory(user.getOrderHistory());
        old.setPoints(user.getPoints());

        return true;
    }

}
