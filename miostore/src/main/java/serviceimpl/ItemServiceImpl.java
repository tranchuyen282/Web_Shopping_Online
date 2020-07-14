package serviceimpl;

import dao.ItemDAO;
import dao.ItemDAOImpl;

import java.util.ArrayList;
import model.item.Item;
import service.ItemService;

public class ItemServiceImpl implements ItemService{

    @Override
    public ArrayList<Item> getAllItem() {
        ArrayList<Item> listItem = null;
        ItemDAOImpl  itemDaoImpl = new ItemDAOImpl();
        listItem = itemDaoImpl.getAllItem();
        return listItem;
    }


    @Override
    public Item getItemByID(int id) {
        ItemDAO itemDAO = new  ItemDAOImpl();
        Item item = itemDAO.getItemById(id);
        return item;
    }

    @Override
    public ArrayList<Item> getItemByType(String type) {
        ArrayList<Item> listItem = null;
        ItemDAOImpl  itemDaoImpl = new ItemDAOImpl();
        listItem = itemDaoImpl.getItemByType(type);
        return listItem;
    }

    @Override
    public ArrayList<Item> getItemByName(String name) {
        ArrayList<Item> listItem = null;
        ItemDAOImpl  itemDaoImpl = new ItemDAOImpl();
        listItem = itemDaoImpl.getItemByName(name);
        return listItem;
    }


}