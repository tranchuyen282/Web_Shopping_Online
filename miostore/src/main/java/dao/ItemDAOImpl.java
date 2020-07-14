package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.item.Detail;
import model.item.Item;
import model.item.ItemRate;

public class ItemDAOImpl extends DAO implements ItemDAO {

    public ItemDAOImpl() {
        getInstance();
    }

    @Override
    public ArrayList<Item> getAllItem() {
        ArrayList<Item> listItem = new ArrayList<Item>();
        try {
            String query = "Select * FROM item";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ItemRate itemRate = null;
            Detail detail = null;
            while (rs.next()) {
                //ItemRate
                int itemRateID = rs.getInt("ItemRateID");
                ItemRateDAO itemRateDAO = new ItemRateDAOImpl();
                itemRate = itemRateDAO.getRateOfItem(itemRateID);

                //Detail
                int detailID = rs.getInt("idDetail");
                DetailDAO detailDAO = new DetailDAOImpl();
                detail = detailDAO.getDetailByID(detailID);

                Item item = new Item();
                item.setId(rs.getInt("ID"));
                item.setNameItem(rs.getString("nameItem"));
                item.setPrice(rs.getInt("price"));
                item.setQuantity(rs.getInt("quantity"));
                item.setCategory(rs.getString("category"));
                item.setStatus(rs.getInt("status"));
                item.setItemRate(itemRate);
                item.setDetail(detail);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listItem;
    }

    @Override
    public Item getItemById(int id) {
        Item item = null;
        String query = "SELECT * FROM item WHERE ID = " + String.valueOf(id);
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ItemRate itemRate = null;
            Detail detail = null;
            if (rs.next()) {
                //ItemRate
                int itemRateID = rs.getInt("ItemRateID");
                ItemRateDAO itemRateDAO = new ItemRateDAOImpl();
                itemRate = itemRateDAO.getRateOfItem(itemRateID);

                //Detail
                int detailID = rs.getInt("idDetail");
                DetailDAO detailDAO = new DetailDAOImpl();
                detail = detailDAO.getDetailByID(detailID);

                //Item
                item = new Item();
                item.setId(rs.getInt("ID"));
                item.setNameItem(rs.getString("nameItem"));
                item.setPrice(rs.getInt("price"));
                item.setQuantity(rs.getInt("quantity"));
                item.setCategory(rs.getString("category"));
                item.setStatus(rs.getInt("status"));
                item.setItemRate(itemRate);
                item.setDetail(detail);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return item;
    }

    @Override
    public ArrayList<Item> getItemByType(String type) {
        if(type.equals("phukien")) type = "Another";
        ArrayList<Item> listItem = new ArrayList<Item>();
        try {
            String query = "Select * FROM item WHERE category ='"+type+"'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ItemRate itemRate = null;
            Detail detail = null;
            while (rs.next()) {
                //ItemRate
                int itemRateID = rs.getInt("ItemRateID");
                ItemRateDAO itemRateDAO = new ItemRateDAOImpl();
                itemRate = itemRateDAO.getRateOfItem(itemRateID);

                //Detail
                int detailID = rs.getInt("idDetail");
                DetailDAO detailDAO = new DetailDAOImpl();
                detail = detailDAO.getDetailByID(detailID);

                Item item = new Item();
                item.setId(rs.getInt("ID"));
                item.setNameItem(rs.getString("nameItem"));
                item.setPrice(rs.getInt("price"));
                item.setQuantity(rs.getInt("quantity"));
                item.setCategory(rs.getString("category"));
                item.setStatus(rs.getInt("status"));
                item.setItemRate(itemRate);
                item.setDetail(detail);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listItem;
    }

    @Override
    public ArrayList<Item> getItemByName(String name) {
        ArrayList<Item> listItem = new ArrayList<Item>();
        try {
            String query = "Select * FROM item WHERE nameItem LIKE '%" +name +"%'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ItemRate itemRate = null;
            Detail detail = null;
            while (rs.next()) {
                //ItemRate
                int itemRateID = rs.getInt("ItemRateID");
                ItemRateDAO itemRateDAO = new ItemRateDAOImpl();
                itemRate = itemRateDAO.getRateOfItem(itemRateID);

                //Detail
                int detailID = rs.getInt("idDetail");
                DetailDAO detailDAO = new DetailDAOImpl();
                detail = detailDAO.getDetailByID(detailID);

                Item item = new Item();
                item.setId(rs.getInt("ID"));
                item.setNameItem(rs.getString("nameItem"));
                item.setPrice(rs.getInt("price"));
                item.setQuantity(rs.getInt("quantity"));
                item.setCategory(rs.getString("category"));
                item.setStatus(rs.getInt("status"));
                item.setItemRate(itemRate);
                item.setDetail(detail);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listItem;
    }

}
