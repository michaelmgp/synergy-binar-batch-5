package com.example.challenge_5.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Seat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private int row;

    private int number;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    private boolean active;
}
