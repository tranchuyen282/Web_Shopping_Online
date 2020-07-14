package com.cfc282.restmiostore.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Province")
    private String province;
    @Column(name = "District")
    private String district;
    @Column(name = "Ward")
    private String ward;
    @Column(name = "Street")
    private String street;
    @Column(name = "HomeNumber")
    private String homeNumber;

}
