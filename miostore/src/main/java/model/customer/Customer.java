package model.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.account.AccountCustomer;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int id;
    private AccountCustomer accountCustomer;
    private String name;
    private String email;
    private String phone;
    private ArrayList<Address> address;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", accountCustomer=" + accountCustomer +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }
}