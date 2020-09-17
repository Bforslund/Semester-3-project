package individual.project.model;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("WeakerAccess")
@XmlRootElement
public class Order {
    public enum orderStatus {
SHIPPED, PENDING
    }

    public Order(int orderNumber, double totalPrice, int userId, String address) {
        this.orderNumber = orderNumber;
        this.totalPrice = totalPrice;
        this.userId = userId;
        this.status = orderStatus.PENDING;
        this.address = address;
    }
    public Order() {
    }
    private int orderNumber;
    private double totalPrice;
    private int userId;
    private orderStatus status;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;

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
}
