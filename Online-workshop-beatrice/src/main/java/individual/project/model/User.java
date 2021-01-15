package individual.project.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "individual_users")
public class User {
    public User(String firstname, String lastname, String address, int points, String birthday, String email, String password, roles role) {

        this.firstName = firstname;
        this.lastName = lastname;
        this.address = address;
        this.points = points;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public User() {
    }

    public User(String firstName, String lastName, String address, String birthday, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.points = 0;
        this.role = roles.USER;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private int id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "points")
    private int points;
    @Column(name = "birthday")
    private String birthday;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private roles role;

    public enum roles {
        ADMIN, USER
    }


    public roles getRole() {
        return role;
    }

    public void setRole(roles role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty())
        {
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty())
        {
            throw new IllegalArgumentException();
        }
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty())
        {
            throw new IllegalArgumentException();
        }this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty())
        {
            throw new IllegalArgumentException();
        }this.password = password;
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
        if (address == null || address.isEmpty())
        {
            throw new IllegalArgumentException();
        }this.address = address;
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
        if (birthday == null || birthday.isEmpty())
        {
            throw new IllegalArgumentException();
        }this.birthday = birthday;
    }


}
