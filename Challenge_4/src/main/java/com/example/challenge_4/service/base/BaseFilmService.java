package com.example.challenge_4.service.base;

import com.example.challenge_4.model.Film;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface BaseFilmService<T> extends BaseServiceResponse<T>{
    Map mengubahNamaFilm(Long id, T t);
    Map menampilkanYangTayang(T tayang);
}
