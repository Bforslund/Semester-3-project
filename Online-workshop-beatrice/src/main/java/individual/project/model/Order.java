package individual.project.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
@XmlRootElement
public class Order {
    public enum orderStatus {
SHIPPED, PENDING
    }

    public Order(int orderNumber, double totalPrice, int userId, String address, String CustomerName) {
        this.orderNumber = orderNumber;
        this.totalPrice = totalPrice;
        this.userId = userId;
        this.status = orderStatus.PENDING;
        this.customerName = CustomerName;
        this.address = address;
        this.time = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        orderedItemsList = new ArrayList<>();
    }

    public Order() {
    }

    private int orderNumber;
    private double totalPrice;
    private int userId;
    private orderStatus status;
    private String time;
    private String address;
    private String customerName;
    private List<OrderItem> orderedItemsList;


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public void AddItemToList(OrderItem i){
        orderedItemsList.add(i);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public orderStatus getStatus() {
        return status;
    }

    public void setStatus(orderStatus status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<OrderItem> getOrderedItemsList() {
        return orderedItemsList;
    }

    public void setOrderedItemsList(List<OrderItem> orderedItemsList) {
        this.orderedItemsList = orderedItemsList;
    }
}
