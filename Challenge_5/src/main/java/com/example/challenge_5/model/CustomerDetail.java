package com.example.challenge_5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
