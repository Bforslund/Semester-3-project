package individual.project.model;


import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("WeakerAccess")
@XmlRootElement
public class OrderItem {
    private int id;
    private Item item;
    private int quantity;

    public OrderItem(int id, Item item, int quantity) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
    }
    public OrderItem(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
