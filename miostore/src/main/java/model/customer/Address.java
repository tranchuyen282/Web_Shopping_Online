/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.customer;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Address {
    private String province;
    private String district;
    private String ward;
    private String street;
    private String homeNumber;
    private int id;
    private int isDefault;
    private String nameReceiver;
    private String phoneReceiver;

    public Address(String province, String district, String ward, String street, String homeNumber, int id, int isDefault, String nameReciever, String phoneReciver) {
        this.province = province;
        this.district = district;
        this.ward = ward;
        this.street = street;
        this.homeNumber = homeNumber;
        this.id = id;
        this.isDefault = isDefault;
        this.nameReceiver = nameReciever;
        this.phoneReceiver = phoneReciver;
    }

    public Address() {
    }

    public String getAdd(){
        String s = "Số " + this.homeNumber + ", đường " + this.street +", "+this.ward+", "+this.district +", " + this.province;
        return  s;
    }


}
