package com.example.challenge_5.model;

import com.example.challenge_5.model.security.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "screenings")
    private Set<Screening> screenings;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "reservation_type_id")
    private ReservationType reservationType;
    private double totalPrice;
    private boolean active;
}
