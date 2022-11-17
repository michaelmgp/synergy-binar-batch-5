package com.example.challenge_5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer_details")
public class CustomerDetail {
    @GeneratedValue
    @Id
    @Column(name = "id")
    private long id;
    @OneToOne(mappedBy = "customer_detail")
    private Customer customer;
}
