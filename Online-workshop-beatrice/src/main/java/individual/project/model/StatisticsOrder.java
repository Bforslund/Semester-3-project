package individual.project.model;

public class StatisticsOrder {
    private String month;
    private int totalOrders;

    public StatisticsOrder(String month, int totalOrders) {
        this.month = month;
        this.totalOrders = totalOrders;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }
}
