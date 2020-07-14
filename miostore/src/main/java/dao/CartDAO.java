/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.ArrayList;
import javafx.util.Pair;
import model.cart.Cart;
import model.cart.ItemCart;
import model.item.*;
/**
 *
 * @author Asus
 */
public interface CartDAO {
    public void createCart(int customerID);
    public void addToCart(int itemID, int quantity, int customerID);
    public ArrayList<ItemCart> getListItemCart(int customerID);
    public void deleteItemCart(int itemCartID);
}
