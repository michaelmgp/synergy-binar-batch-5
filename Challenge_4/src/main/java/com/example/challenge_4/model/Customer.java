package com.example.challenge_4.model;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

}
