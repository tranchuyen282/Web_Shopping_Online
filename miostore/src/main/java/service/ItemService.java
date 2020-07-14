package service;

import java.util.ArrayList;
import model.item.Item;
import model.product.Product;

public interface ItemService {
      ArrayList<Item> getAllItem();
      Item getItemByID(int id);
      ArrayList<Item> getItemByType(String type);
      ArrayList<Item> getItemByName(String name);
}