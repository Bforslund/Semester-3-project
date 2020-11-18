package individual.project.controllers;

import individual.project.model.Order;
import individual.project.model.OrderItem;
import individual.project.model.User;
import individual.project.repository.HibernateOrdersRepository;

import java.util.List;

public class OrderController {
    HibernateOrdersRepository ordersRepository = new HibernateOrdersRepository();
    UserController userController = new UserController();
    public List<Order> showAllOrders() {
      List<Order> orders;
        try {
            orders = ordersRepository.getOrders();
           return orders;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      return null;
    }
    public List<OrderItem> showAllOrderItems(int nr) {
        List<OrderItem> orderitems;
        try {
            orderitems = ordersRepository.getOrderItems(nr);
            return orderitems;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public List<Order> showAllOrdersOfOneUser(int userId) {
        List<Order> orders;
        try {
            orders = ordersRepository.getAllOrderOfOneUser(userId);
            return orders;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
   public boolean addOrder(Order o) {
        try {
            ordersRepository.create(o);
            System.out.println("Created order: " + o);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean addOrderItem(OrderItem o) {
        try {
            Order order = o.getOrder();
            order.AddItemToList(o);
            ordersRepository.update(order);
            System.out.println("Created order: " + o);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean updateOrder(Order o) {
        try {
            ordersRepository.update(o);
            System.out.println("Updated order: " + o);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Order getOrderById(int id) {
        try {
           Order o = ordersRepository.getOrderById(id);
            return o;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void deleteAll() {
        try {
            ordersRepository.delete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public User getUserByOrder(int id) {

        try {
            Order o = ordersRepository.getOrderById(id);
            int userId = o.getUserId();
          User user = userController.getUserById(userId);
            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
