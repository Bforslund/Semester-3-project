package individual.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {
    @Test
        //check whether info are correct
    void NewItemTest()
    {

        Item u = new Item( "Cake", 50, 100,"Flour", Item.TypeOfItem.CAKE);


        assertEquals("Cake", u.getName());
        assertEquals(50, u.getSellingPrice());
        assertEquals(100, u.getBuyingPrice());
        assertEquals("Flour", u.getIngredients());
        assertEquals(Item.TypeOfItem.CAKE, u.getType());


    }

    @Test
    void setItemNameWithNullValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        Item i = new Item();
        i.setName(null);
        });
    }

    @Test
    void setItemNameWithEmptyValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        Item i = new Item();
        i.setName("");
        });
    }

    @Test
    void setItemIngredientsWithNullValue() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
        Item i = new Item();
        i.setIngredients(null);
            });
    }

    @Test
    void setItemIngredientsWithEmptyValue() {
                Assertions.assertThrows(IllegalArgumentException.class, () -> {
        Item i = new Item();
        i.setIngredients("");
                });
    }

    @Test
    void setSellingPriceWithNullValue() {
                    Assertions.assertThrows(IllegalArgumentException.class, () -> {
        Item i = new Item();
        i.setSellingPrice(0);
                    });
    }
    @Test
    void setSellingPriceWithLessValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Item i = new Item();
            i.setSellingPrice(-1);
        });
    }
    @Test
    void setSellingPriceWithLessThanBuyingValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Item i = new Item();
            i.setBuyingPrice(50);
            i.setSellingPrice(30);
        });
    }
    @Test
    void setBuyingPriceWithEmptyValue() {
                        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        Item i = new Item();
        i.setBuyingPrice(0);
                        });
    }
    @Test
    void setBuyingPriceWithLessValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Item i = new Item();
            i.setBuyingPrice(-1);
        });
    }
    @Test
    void setTypeWithNullValue() {
                            Assertions.assertThrows(IllegalArgumentException.class, () -> {
        Item i = new Item();
        i.setType(null);
                            });
    }
    @Test
    void setType() {
        Item i = new Item();
        i.setType(Item.TypeOfItem.COOKIE);
        assertEquals(Item.TypeOfItem.COOKIE, i.getType());
    }
    @Test
    void setIngredients() {
        Item i = new Item();
        i.setIngredients("test");
        assertEquals("test", i.getIngredients());
    }
    @Test
    void setBuyingPrice() {
        Item i = new Item();
        i.setBuyingPrice(6);
        assertEquals(6, i.getBuyingPrice());
    }
    @Test
    void setSellingPrice() {
        Item i = new Item();
        i.setBuyingPrice(6);
        i.setSellingPrice(10);
        assertEquals(10, i.getSellingPrice());
    }
    @Test
    void setName() {
        Item i = new Item();
        i.setName("cake");
        assertEquals("cake", i.getName());
    }
    @Test
    void setId() {
        Item i = new Item();
        i.setId(1);
        assertEquals(1, i.getId());
    }
}
