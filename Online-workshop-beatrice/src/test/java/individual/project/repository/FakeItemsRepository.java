package individual.project.repository;
import individual.project.model.Item;

import java.util.ArrayList;
import java.util.List;
public class FakeItemsRepository implements IItemRepository {
    List<Item> itemList = new ArrayList<>();
public FakeItemsRepository(){
    Item i1 = new Item( "Cake", 50, 5,"Flour", Item.TypeOfItem.CAKE);
    Item i2 = new Item("Cookie", 70, 5,"Flour", Item.TypeOfItem.COOKIE);
    Item i3 = new Item( "Strass", 30, 5,"Flour", Item.TypeOfItem.OTHER);
    Item i4 = new Item("Cupcake", 10, 5,"Flour", Item.TypeOfItem.CUPCAKE);
    Item i5 = new Item("Cupcake", 10, 5,"Flour", Item.TypeOfItem.CUPCAKE);
    itemList.add(i1);
    itemList.add(i2);
    itemList.add(i3);
    itemList.add(i4);
    itemList.add(i5);
}

    @Override
    public List<Item> getItems() throws Exception {
        return itemList;
    }

    @Override
    public void create(Item i) throws Exception {

    }

    @Override
    public Item getItemById(int id) throws Exception {
        return null;
    }

    @Override
    public void update(Item item) throws Exception {

    }

    @Override
    public void delete(int id) throws Exception {

    }
}
