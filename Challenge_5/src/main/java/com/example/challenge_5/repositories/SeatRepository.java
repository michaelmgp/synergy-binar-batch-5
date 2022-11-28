package com.example.challenge_5.repositories;

import com.example.challenge_5.model.Seat;
import com.example.challenge_5.model.Theater;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends BaseRepository<Seat>{

    List<Seat> findAllByTheaterAndActive(Theater theater, Boolean active);
}
