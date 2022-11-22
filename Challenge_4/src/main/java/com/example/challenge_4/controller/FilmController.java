//package com.example.challenge_4.controller;
//
//import com.example.challenge_4.controller.base.BaseController;
//import com.example.challenge_4.model.Film;
//import com.example.challenge_4.model.dto.FilmDTO;
//import com.example.challenge_4.service.FilmService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/film")
//public class FilmController implements BaseController<FilmDTO> {
//
//    @Autowired
//    private FilmService filmService;
//
//    @Override
//    @PostMapping("/save")
//    public ResponseEntity<Map> save(FilmDTO film) {
//        return new ResponseEntity<Map>(filmService.tambahFilm(film), HttpStatus.OK);
//    }
//
//    @Override
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Map> update(FilmDTO film,@PathVariable("id") long id) {
//        return new ResponseEntity<Map>(filmService.mengubahNamaFilm(id,film),HttpStatus.OK);
//    }
//
//    @Override
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Map> delete(@PathVariable("id") Long id) {
//        return new ResponseEntity<Map>(filmService.menghapusFilm(id), HttpStatus.ACCEPTED);
//    }
//
//    @Override
//    @GetMapping("/find-all")
//    public ResponseEntity<Map> findAll() {
//        return new ResponseEntity<Map>(filmService.menampilkanSemuafilm(),HttpStatus.OK);
//    }
//
//    @GetMapping("/find-tayang")
//    public ResponseEntity<Map> findTayang(@RequestBody FilmDTO filmDTO){
//        return new ResponseEntity<Map>(filmService.menampilkanYangTayang(filmDTO), HttpStatus.OK);
//    }
//}
