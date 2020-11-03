package individual.project.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "individual_items")
public class Item {



    public enum TypeOfItem {
        CAKE, CUPCAKE, COOKIE, OTHER
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

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(int buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public TypeOfItem getType() {
        return type;
    }

    public void setType(TypeOfItem type) {
        this.type = type;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "selling_price")
    private int sellingPrice;
    @Column(name = "buying_price")
    private int buyingPrice;
    @Column(name = "ingredients")
    private String ingredients;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TypeOfItem type;


    public Item(String name, int sellingPrice, int buyingPrice, String ingredients, TypeOfItem type) {
        this.name = name;
        this.sellingPrice = sellingPrice;
        this.buyingPrice = buyingPrice;
        this.ingredients = ingredients;
        this.type = type;

    }

    public Item() {
    }

    @Override
    public String toString() {
        return name +": " + ingredients + ": " + sellingPrice;
    }

    // TODO check so that values cant be null or 0
}
