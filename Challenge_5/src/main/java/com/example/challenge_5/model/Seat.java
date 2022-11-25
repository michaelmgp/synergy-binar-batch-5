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

    @Column(name = "baris")
    private int row;

    @Column(name = "nomor")
    private int number;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    private boolean active;
}
