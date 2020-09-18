package individual.project.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@SuppressWarnings("WeakerAccess")
@XmlRootElement
public class User {
    public User(int id, String name, String address, int points, LocalDate birthday, String orderHistory, String email, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.points = points;
        this.birthday = birthday;
        this.orderHistory = orderHistory;
        this.email = email;
        this.password = password;
    }
    public User() {
    }
    private int id;
    private String name;
    private String address;
    private int points;
    private LocalDate birthday;
    private String orderHistory;
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(String orderHistory) {
        this.orderHistory = orderHistory;
    }
}
