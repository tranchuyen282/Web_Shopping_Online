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
@Table(name = "customeraddress")
public class CustomerAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Id
    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @Id
    @OneToOne
    @JoinColumn(name = "AddressID")
    private Address address;

    @Column(name = "Default")
    private int defaultAdd;
}
