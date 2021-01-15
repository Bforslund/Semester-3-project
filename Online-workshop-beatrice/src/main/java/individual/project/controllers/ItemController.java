package individual.project.controllers;
import individual.project.model.*;
import individual.project.repository.*;

import java.util.ArrayList;
import java.util.List;

public class ItemController {
    IItemRepository itemsRepository;
public ItemController(IItemRepository itemsRepository){
this.itemsRepository = itemsRepository;
}
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
    public List<Item> filterByType(Item.TypeOfItem type, double price) {
        List<Item> items;

        try {
            items = itemsRepository.getItems();
            List<Item> foundItems = new ArrayList<>();
            if(price == 0){
                for (Item i:items) {
                    if(i.getType().equals(type)){
                        foundItems.add(i);
                    }
                }
            }else{
                if(type == null){
                    for (Item i:items) {
                        if(i.getSellingPrice() <= price){
                            foundItems.add(i);
                        }
                    }
                }else{
                    for (Item i:items) {
                        if(i.getType().equals(type) && i.getSellingPrice() <= price){
                            foundItems.add(i);
                        }
                    }
                }

            }

            return foundItems;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Item.TypeOfItem MakeToEnum(String type){
        Item.TypeOfItem i;
        switch (type){
            case "CAKE":
                i = Item.TypeOfItem.CAKE;
                break;
            case "COOKIE":
                i = Item.TypeOfItem.COOKIE;
                break;
            case "CUPCAKE":
                i = Item.TypeOfItem.CUPCAKE;
                break;
            case "OTHER":
                i = Item.TypeOfItem.OTHER;
                break;
            default:
                i = null;
        }
        return i;
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
    public boolean UpdateItem(Item i) {
        try {
            itemsRepository.update(i);
            System.out.println("Updated item: " + i);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean DeleteItem(int id) {
        try {
            itemsRepository.delete(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
