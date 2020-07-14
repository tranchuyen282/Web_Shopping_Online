package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.item.ItemRate;

public class ItemRateDAOImpl extends DAO implements ItemRateDAO{

    public ItemRateDAOImpl() {
        getInstance();
    }

    @Override
    public ItemRate getRateOfItem(int ItemRateID) {
        ItemRate itemRate = null;
        try{
            String query = "Select * from itemrate where id = "+ String.valueOf(ItemRateID);
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                itemRate = new ItemRate();
                itemRate.setComment(rs.getString("Comment"));
                itemRate.setStar(rs.getInt("Star"));
            }
            
        }catch(SQLException ex){
            Logger.getLogger(ItemRateDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itemRate;
    }
    
    
    

}