package com.aminenurgynk.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "CUSTOMERS")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    private int phone_number;
    @Embedded
    private Address address;


    // FIXME acikken kiralama methodunda word dosyasina yuklemis oldugum hatayi veriyor..
/*    @ToString.Exclude
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Rent> rentList;*/


}
