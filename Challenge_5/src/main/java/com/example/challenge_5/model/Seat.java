package com.example.challenge_5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "seats")
public class Seat {
    @GeneratedValue
    @Id
    private long id;
    private int row;
    private int number;
    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;
}
