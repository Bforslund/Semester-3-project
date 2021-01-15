package individual.project.model;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
    @Test
        //check whether order info are correct
    void NewOrderTest()
    {
        Order u = new Order(1, "address", "Anna", 3500, new ArrayList<>());


        assertEquals(1, u.getUserId());
        assertEquals("address", u.getAddress());
        assertEquals("Anna", u.getCustomerName());
        assertEquals(3500, u.getTotalPrice());
        assertEquals(0, u.getOrderedItemsList().size());


    }

    @Rule // this rule is added to throw exceptions when its needed
    ExpectedException thrown = ExpectedException.none();

    @Test // user first name null
    void setOrderAddressWithNullValue() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Address must not be null");

        Order o = new Order();
       o.setAddress(null);
    }

    @Test // user first name string is empty
    void setOrderAddressWithEmptyValue() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Address  must not be empty");

        Order o = new Order();
        o.setAddress(" ");
    }

    @Test // user last name null
    void setOrderCustomerNameWithNullValue() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Customer name must not be null");

        Order o = new Order();
        o.setCustomerName(null);
    }

    @Test // user last name string is empty
    void setOrderCustomerNameWithEmptyValue() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Customer name must not be empty");

        Order o = new Order();
        o.setCustomerName(" ");
    }

    @Test // user email null
    void setTotalPriceWith0Value() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Total price must not be 0");

        Order o = new Order();
        o.setTotalPrice(0);
    }
    @Test
    void setUserId() {
        Order o = new Order();
        o.setUserId(1);
        assertEquals(1, o.getUserId());
    }
    @Test
    void setStatus() {
        Order o = new Order();
        o.setStatus(Order.orderStatus.PENDING);
        assertEquals(Order.orderStatus.PENDING, o.getStatus());
    }
    @Test
    void setTime() {
        Order o = new Order();
        o.setTime(LocalDate.now());
        assertEquals(LocalDate.now(), o.getTime());
    }
    @Test
    void setList() {
        Order o = new Order();
        List<OrderItem> orderList = new ArrayList<>();
        o.setOrderedItemsList(orderList);
        assertEquals(0, o.getOrderedItemsList().size());
    }

}
