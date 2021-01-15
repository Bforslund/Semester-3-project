package individual.project.model;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderItemTest {
    Item i1 = new Item( "Cake", 50, 100,"Flour", Item.TypeOfItem.CAKE);
    @Test
    void NewOrderTest()
    {
        OrderItem u = new OrderItem(i1, 2);
        assertEquals(i1.getName(), u.getItem().getName());
        assertEquals(2, u.getQuantity());

    }

    @Rule // this rule is added to throw exceptions when its needed
    ExpectedException thrown = ExpectedException.none();

    @Test
    void setOrderAddressWithNullValue() {
        thrown.expect(IllegalArgumentException.class);

        OrderItem o = new OrderItem();
        o.setOrder(null);
    }


    @Test // user last name null
    void setOrderCustomerNameWithNullValue() {
        thrown.expect(IllegalArgumentException.class);

        OrderItem o = new OrderItem();
        o.setItem(null);
    }

    @Test // user last name string is empty
    void setOrderCustomerNameWithEmptyValue() {
        thrown.expect(IllegalArgumentException.class);

        OrderItem o = new OrderItem();
        o.setId(-2);
    }

    @Test // user email null
    void setTotalPriceWith0Value() {
        thrown.expect(IllegalArgumentException.class);


        OrderItem o = new OrderItem();
        o.setQuantity(0);
    }
    @Test
    void getOrder() {
        OrderItem o = new OrderItem();
        Order u = new Order(1, "address", "Anna", 3500, new ArrayList<>());

        o.setOrder(u);
        assertEquals("address", o.getOrder().getAddress());
    }
    @Test
    void getOrderItemId() {
        OrderItem o = new OrderItem();

        o.setId(1);
        assertEquals(1, o.getId());
    }
}
