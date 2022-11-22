package com.example.challenge_5.repositories;

import com.example.challenge_5.model.SeatReserved;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatReservedRepository extends BaseRepository<SeatReserved>{
   List<SeatReserved> findAllByReservationId(long id);
}
