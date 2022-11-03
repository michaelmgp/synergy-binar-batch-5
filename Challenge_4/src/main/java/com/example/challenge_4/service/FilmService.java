package com.example.challenge_4.service;

import com.example.challenge_4.model.Film;
import com.example.challenge_4.model.dto.FilmDTO;
import com.example.challenge_4.repositories.FilmRepository;
import com.example.challenge_4.service.base.BaseFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService implements BaseFilmService<Film, FilmDTO> {
    @Autowired
    private FilmRepository filmRepository;
    @Override
    public void tambahFilm(Film film) {
        filmRepository.save(film);
    }

    @Override
    public void mengubahNamaFilm(Long id, FilmDTO filmDTO) {
        Film film = filmRepository.findById(id).get();
        film.setName(filmDTO.getName());
        filmRepository.save(film);
    }


    @Override
    public void menghapusFilm(long id) {
        filmRepository.deleteById(id);
    }

    @Override
    public List<Film> menampilkanYangTayang(String tayang) {

        return filmRepository.findAllByTayang(tayang);
    }
}
