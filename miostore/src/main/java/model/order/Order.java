/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.cart.Cart;
import model.delivery.Delivery;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderDate;
    private Delivery delivery;
    private OrderStatus orderStatus;
    private Cart cart;
    private int id;
}
