package com.example.challenge_4.service.base;

import com.example.challenge_4.model.Film;

import java.time.LocalDateTime;
import java.util.List;

public interface BaseFilmService<T,V>{
    void tambahFilm(Film film);
    void mengubahNamaFilm(Long id, V filmDTO);
    void menghapusFilm(long id);
    List<T> menampilkanYangTayang(String tayang);
}
