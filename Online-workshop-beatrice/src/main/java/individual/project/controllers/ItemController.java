package individual.project.controllers;
import individual.project.model.*;
import individual.project.repository.*;

import java.util.ArrayList;
import java.util.List;

public class ItemController {
    HibernateItemsRepository itemsRepository = new HibernateItemsRepository();

    public List<Item> showAllItems() {
      List<Item> items;
        try {
            items = itemsRepository.getItems();
           return items;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      return null;
    }
    public List<Item> search(String term) {
        List<Item> items;
       String searchTerm = term.toLowerCase();
        try {
            items = itemsRepository.getItems();
            List<Item> foundItems = new ArrayList<>();
            for (Item i:items) {
                if(i.getName().toLowerCase().indexOf(searchTerm) >= 0){
                    foundItems.add(i);
                }
            }
            return foundItems;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
   public boolean addItem(Item i) {
        try {
            itemsRepository.create(i);
            System.out.println("Created item: " + i);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Item getItemById(int id) {
        try {
            Item o = itemsRepository.getItemById(id);
            return o;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void UpdateItem(Item i) {
        try {
            itemsRepository.update(i);
            System.out.println("Updated item: " + i);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void DeleteItem(int id) {
        try {
            itemsRepository.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
