package individual.project.repository;
import individual.project.model.Item;
import java.util.List;
public interface IItemRepository {
    List<Item> getItems() throws Exception;

    void create(Item i) throws Exception;

    Item getItemById(int id) throws Exception;

    void update(Item item) throws Exception;

    void delete(int id) throws Exception;
}
