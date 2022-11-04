package com.example.challenge_4.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @GeneratedValue
    @Id
    private long id;
    private String username;
    private String emailAddress;
    private String password;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "seats")
    private List<Seat> seats;

}
