package individual.project.repository;

import individual.project.model.Order;
import individual.project.model.OrderItem;
import individual.project.model.User;

import java.util.List;

public interface IOrdersRepository {
    List<Order> getOrders() throws Exception;

    List<Order> getAllOrderOfOneUser(int userId) throws Exception;

    List<OrderItem> getOrderItems(int nr) throws Exception;

    Order getOrderById(int orderNumber) throws Exception;

    User getUserfromOrder(int orderNumber) throws Exception;

    void create(Order o) throws Exception;

    void update(Order o) throws Exception;

    void delete() throws Exception;
}
