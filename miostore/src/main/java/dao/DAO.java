package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    protected static Connection con;

    public DAO() {
    }
    
    protected static void getInstance(){
        if(con == null){
            String dbUrl = "jdbc:mysql://localhost:3306/store?useUnicode=yes&characterEncoding=UTF-8";
            String dbClass = "com.mysql.jdbc.Driver";
            try{
                Class.forName(dbClass);
                con = DriverManager.getConnection(dbUrl,"root", "");

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}