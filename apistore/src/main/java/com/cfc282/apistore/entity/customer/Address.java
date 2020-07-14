/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfc282.apistore.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {
    private String province, district, ward, street, homeNumber;
    private int id;
}
