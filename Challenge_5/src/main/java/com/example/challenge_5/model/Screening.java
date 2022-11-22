package com.example.challenge_5.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Screening {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;
    @DateTimeFormat(pattern = "dd-M-yyyy")
    private LocalDate screeningDate;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime screeningStart;
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "reservation_id", insertable = false, updatable = false)
//    private Reservation reservation;

//    @JsonIgnore
    @Transient
    private String screeningDateString;

//    @JsonIgnore
    @Transient
    private String screeningStartString;

//    public Reservation getReservation() {
//        return reservation;
//    }
//
//    public void setReservation(Reservation reservation) {
//        this.reservation = reservation;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public LocalDate getScreeningDate() {
        return screeningDate;
    }

    public void setScreeningDate(LocalDate screeningDate) {
        this.screeningDate = screeningDate;
    }

    public void setScreeningDateFormatted(String screeningdDateFormatted){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-M-yyyy");
        LocalDate localDate = LocalDate.parse(screeningdDateFormatted, formatter);
        this.screeningDate = localDate;
    }


    public LocalTime getScreeningStart() {
        return screeningStart;
    }

    public void setScreeningStart(LocalTime screeningStart) {
        this.screeningStart = screeningStart;
    }
    public void setScreeningStartFormatted(String screeningTimeFormatted){
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTimeFormatted = LocalTime.parse(screeningTimeFormatted);
        this.screeningStart = localTimeFormatted;
    }

    public String getScreeningDateString() {
        return screeningDateString;
    }

    public String getScreeningStartString() {
        return screeningStartString;
    }
}
