package com.example.challenge_5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "screenings")
public class Screening {
    @GeneratedValue
    @Id
    private long id;
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate screeningDate;
    @DateTimeFormat(pattern = "HH-mm")
    private LocalTime screeningStart;
}
