package com.example.challenge_5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ReservationType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String type;
}
