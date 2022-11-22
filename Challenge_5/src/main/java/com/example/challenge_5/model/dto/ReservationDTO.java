package com.example.challenge_5.model.dto;

import com.example.challenge_5.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    Set<Screening> screeningSet;
    Customer customer;
    ReservationType reservationType;
}
