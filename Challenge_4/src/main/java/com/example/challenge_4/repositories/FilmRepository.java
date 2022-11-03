package com.example.challenge_4.repositories;

import com.example.challenge_4.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query(value = "SELECT f.tayang FROM Film f ")
    Film findByCode(String code);

    Film findByName(String name);

    List<Film> findAllByTayang(String tayang);
}
