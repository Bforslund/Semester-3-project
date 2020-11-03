package individual.project.model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "individual_itemsStatistics")
public class ItemStatistics {
    @Column(name = "id")
    private int itemId;
    @Column(name = "totalSold")
    private int totalSold;
    @Column(name = "soldPerMonth")
    private int soldPerMonth;

    public int getItemId() {
        return itemId;
    }

    public int getTotalSold() {
        return totalSold;
    }

    public int getSoldPerMonth() {
        return soldPerMonth;
    }
//    public double GetTotalRevenue(){
//        double total = 0;
//        for (Order o:orderList) {
//          total += o.getTotalPrice();
//        }
//        return total;
//    }

}
