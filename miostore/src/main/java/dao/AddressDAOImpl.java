package dao;

import model.customer.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddressDAOImpl extends DAO implements AddressDAO{

    @Override
    public Address getAddressByID(int addressID) {
        Address address = null;
        try {
            String query = "SELECT * FROM address WHERE ID = " + addressID + ";";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                address = new Address();
                address.setProvince(rs.getString("Province"));
                address.setDistrict(rs.getString("District"));
                address.setWard(rs.getString("Ward"));
                address.setStreet(rs.getString("Street"));
                address.setHomeNumber(rs.getString("HomeNumber"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return address;
    }

    @Override
    public ArrayList<Address> getListAddress(int CustomerID) {
        ArrayList<Address> listAddress = new ArrayList<Address>();
        String query = "SELECT address.ID,Province,District,Ward,Street,HomeNumber,NameReceiver,PhoneReceiver,customeraddress.isDefault FROM customeraddress,address\n" +
                "WHERE customeraddress.CustomerID ="+String.valueOf(CustomerID)+"\n" +
                "AND customeraddress.AddressID = address.ID";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Address address = new Address();
                address.setProvince(rs.getString("Province"));
                address.setDistrict(rs.getString("District"));
                address.setWard(rs.getString("Ward"));
                address.setStreet(rs.getString("Street"));
                address.setHomeNumber(rs.getString("HomeNumber"));
                address.setIsDefault(rs.getInt("isDefault"));
                address.setNameReceiver(rs.getString("NameReceiver"));
                address.setPhoneReceiver(rs.getString("PhoneReceiver"));
                listAddress.add(address);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listAddress;
    }

}
