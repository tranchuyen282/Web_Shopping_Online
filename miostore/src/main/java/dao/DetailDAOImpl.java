package dao;

import model.item.Detail;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailDAOImpl extends DAO implements DetailDAO {
    public DetailDAOImpl(){
        getInstance();
    }
    @Override
    public Detail getDetailByID(int detailID) {
        Detail detail = null;
        try {
            String query = "SELECT * FROM detail WHERE ID = " + String.valueOf(detailID);
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                detail = new Detail();
                detail.setId(rs.getInt("ID"));
                detail.setProvider(rs.getString("Provider"));
                detail.setMemory(rs.getString("Memory"));
                detail.setModel(rs.getString("Model"));
                detail.setColor(rs.getString("Color"));
                detail.setImage(rs.getString("Image"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return detail;
    }
}
