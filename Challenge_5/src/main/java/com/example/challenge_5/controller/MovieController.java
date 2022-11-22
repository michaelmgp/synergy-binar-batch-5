package com.example.challenge_5.controller;
import com.example.challenge_5.model.Movie;
import com.example.challenge_5.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController
@RequestMapping("/movie")
public class MovieController implements BaseController<Movie>{
    @Autowired
    private MovieService movieService;

    @Override
    @PostMapping("/save")
    public ResponseEntity<Map> save(Movie movie) {
        return new ResponseEntity<Map>(movieService.save(movie), HttpStatus.OK);
    }
    @Override
    @GetMapping("/get-all")
    public ResponseEntity<Map> getAll() {
        return new ResponseEntity<Map>(movieService.getAll(), HttpStatus.OK);
    }
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Map> getOne(long id) {
        return new ResponseEntity<Map>(movieService.getOne(id), HttpStatus.OK);
    }
    @Override
    @PutMapping("/update")
    public ResponseEntity<Map> update(Movie movie) {
        return new ResponseEntity<Map>(movieService.update(movie), HttpStatus.OK);
    }
    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map> delete(long id) {
        return new ResponseEntity<>(movieService.delete(id), HttpStatus.OK);
    }
}
