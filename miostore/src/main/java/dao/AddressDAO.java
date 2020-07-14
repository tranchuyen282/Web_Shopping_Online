package dao;

import model.customer.Address;

import java.util.ArrayList;

public interface AddressDAO {
    Address getAddressByID(int addressID);
    ArrayList<Address> getListAddress(int CustomerID);
}
