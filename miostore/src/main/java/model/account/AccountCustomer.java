package model.account;

public class AccountCustomer {
    private int id;
    private String username;
    private String password;

    public AccountCustomer() {
    }

    public AccountCustomer(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    

    public int getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AccountCustomer{" + "username=" + username + ", password=" + password + '}';
    }
    
    
}