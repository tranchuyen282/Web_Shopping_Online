package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.customer.Customer;

public class CustomerDAOimpl extends DAO implements CustomerDAO{

    public CustomerDAOimpl() {
        getInstance();
    }
    

    @Override
    public Customer getCustomerByIDAccount(int AccountID) {
        Customer customer = null;
         try {     
            String query = "Select * from customer WHERE AccountID = " + String.valueOf(AccountID) +";";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                customer = new Customer();
                customer.setId(rs.getInt("ID"));
                customer.setEmail(rs.getString("Email"));
                customer.setName(rs.getString("Name"));
                customer.setPhone(rs.getString("Phone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         AddressDAO addressDAO = new AddressDAOImpl();
         customer.setAddress(addressDAO.getListAddress(customer.getId()));
        
        return customer;
    }

}