/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.delivery;

import ghn.entity.MethodGHN;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import model.customer.Address;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Delivery {
    private int id;
    private Address address;
    private MethodGHN deliveryMethod;
}
