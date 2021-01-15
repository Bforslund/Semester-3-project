package individual.project.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticsOrderTest {

    @Test
    void setTotalOrders() {
        StatisticsOrder s = new StatisticsOrder();
        s.setTotalOrders(1);
        assertEquals(1, s.getTotalOrders());
    }
    @Test
    void setMonth() {
        StatisticsOrder s = new StatisticsOrder();
        s.setMonth("October");
        assertEquals("October", s.getMonth());
    }
}
