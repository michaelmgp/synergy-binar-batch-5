package com.example.challenge_4.model;
import com.example.challenge_4.enums.Tayang;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "films")
public class Film {
    @GeneratedValue
    @Id
    private long id;

    private String code;
    private String name;

    @Enumerated
    private Tayang tayang;
//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    private Customer customer;

//    @ManyToMany(fetch = FetchType.LAZY,
//    cascade = {
//            CascadeType.MERGE,
//            CascadeType.PERSIST
//    })
//    @JoinTable(name = "film_schedule",
//            joinColumns ={@JoinColumn(name = "film_id")} ,
//            inverseJoinColumns = {@JoinColumn(name = "schedule_id")})
//    private List<Schedule> schedules = new ArrayList<>();
}
