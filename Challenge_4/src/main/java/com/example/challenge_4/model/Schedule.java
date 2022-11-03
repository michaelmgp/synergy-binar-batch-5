package com.example.challenge_4.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "schedules")
public class Schedule {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
//    @ManyToMany(fetch = FetchType.LAZY,
//    cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE
//    },
//    mappedBy = "schedules")
//    @JsonIgnore
//    private List <Film> films = new ArrayList<>();

    @DateTimeFormat(pattern = "dd-MM-yy")
    private LocalDate jadwalTayang;
    private LocalTime jamMulai;
    private LocalTime jamSelesai;

}
