package individual.project.model;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("WeakerAccess")
@XmlRootElement
public class Item {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private int id;
    private String name;
    private int price;
    private String ingredients;
    private String type;

    public Item(int id, String name, int price, String ingredients,String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.type = type;
    }

    public Item() {
    }

    @Override
    public String toString() {
        return name +": " + ingredients + ": " + price;
    }

    // TODO check so that values cant be null or 0
}
