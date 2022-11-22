package com.example.challenge_4.repositories;
import com.example.challenge_4.enums.Tayang;
import com.example.challenge_4.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
//    @Query(value = "SELECT f.tayang FROM Film f ")
//    Film findByCode(String code);

    Film findByName(String name);

    List<Film> findAllByTayang(Tayang tayang);
//    Page<Film>findAll(Pageable pageable);
    @Query(value = "FROM Film f WHERE LOWER(f.name) LIKE LOWER(concat('%', :name, '%')) ")
    Page<Film> findByName(@Param("name") String name, Pageable pageable);

    @Query(value = "FROM Film f WHERE LOWER(f.name) LIKE LOWER(concat('%', :name, '%')) " +
            "AND LOWER(f.code) LIKE LOWER(concat('%', :code, '%')) " )
    Page<Film> findByNameAndCode(@Param("name") String name, @Param("code") String code, Pageable pageable);

    @Query(value = "FROM Film f WHERE LOWER(f.code) LIKE LOWER(concat('%', :code, '%')) ")
    Page<Film> findByCode(@Param("code") String code, Pageable pageable);

    @Query(value = "SELECT f FROM  Film f ")
    Page<Film> getAllData(Pageable pageable);

}
