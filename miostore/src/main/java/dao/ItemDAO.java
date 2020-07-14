/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.item.Item;

public interface ItemDAO {
    ArrayList<Item> getAllItem();
    Item getItemById(int id);
    ArrayList<Item> getItemByType(String type);
    ArrayList<Item> getItemByName(String name);
}
