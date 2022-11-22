package com.example.challenge_5.repositories;

import com.example.challenge_5.model.Screening;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningReposiotry extends BaseRepository<Screening>{
    Screening findScreeningByMovieIdAndTheaterId(long movieId, long theaterId);
}
