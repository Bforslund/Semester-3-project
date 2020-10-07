package individual.project.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@SuppressWarnings("WeakerAccess")
@XmlRootElement
public class User {
    public User(int id, String firstname, String lastname, String address, int points, String birthday, String orderHistory, String email, String password) {
        this.id = id;
        this.firstName = firstname;
        this.lastName = lastname;
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
    private String firstName;
    private String lastName;
    private String address;
    private int points;
    private String birthday;
    private String orderHistory;
    private String email;
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(String orderHistory) {
        this.orderHistory = orderHistory;
    }
}
