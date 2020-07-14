package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import md5.MD5Library;
import model.account.AccountCustomer;

public class AccountCustomerDAOImpl extends DAO implements AccountCustomerDAO {
    public AccountCustomerDAOImpl() {
        getInstance();
    }
    @Override
    public AccountCustomer getAccount(String username, String password) {
        AccountCustomer accountCustomer = null;
        MD5Library md5 = new MD5Library();
        //querry DB
        try {     
            String query = "Select * FROM account_customer WHERE Username ='" + username+"'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String encrpy = md5.encrypt(rs.getString("Password"));
                if(encrpy.equals(password)){
                    accountCustomer = new AccountCustomer();
                    accountCustomer.setId(rs.getInt("ID"));
                    accountCustomer.setUsername(rs.getString("Username"));
                    accountCustomer.setPassword(encrpy);
                    break;
                }
            }
             
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountCustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //
        return accountCustomer;
    }

}