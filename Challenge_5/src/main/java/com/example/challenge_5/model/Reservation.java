package com.example.challenge_5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservations")
public class Reservation {
    @GeneratedValue
    @Id
    private long id;
    @ManyToOne
    @JoinColumn(name = "screening_id")
    private Screening screening;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "reservation_type_id")
    private ReservationType reservationType;
    private boolean paid;
    private boolean active;
}
