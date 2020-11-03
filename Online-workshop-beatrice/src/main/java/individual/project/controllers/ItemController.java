package individual.project.controllers;
import individual.project.model.*;
import individual.project.repository.*;

import java.util.List;

public class ItemController {
    HibernateItemsRepository itemsRepository = new HibernateItemsRepository();

    public List<Item> showAllItems() {
      List<Item> items;
        try {
            items = itemsRepository.getItems();
           return items;
        } catch (Exception e) {
            e.printStackTrace();
        }
      return null;
    }
   public boolean addItem(Item i) {
        try {
            itemsRepository.create(i);
            System.out.println("Created item: " + i);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Item getItemById(int id) {
        try {
            Item o = itemsRepository.getItemById(id);
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void UpdateItem(Item i) {
        try {
            itemsRepository.update(i);
            System.out.println("Updated item: " + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void DeleteItem(int id) {
        try {
            itemsRepository.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
