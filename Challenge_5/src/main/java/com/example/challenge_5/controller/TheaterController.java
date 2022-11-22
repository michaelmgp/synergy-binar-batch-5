package com.example.challenge_5.controller;

import com.example.challenge_5.model.Theater;
import com.example.challenge_5.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/theater")
public class TheaterController implements BaseController<Theater>{
    @Autowired
    private TheaterService theaterService;
    @Override
    public ResponseEntity<Map> save(Theater theater) {
        return new ResponseEntity<Map>(theaterService.save(theater), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> getAll() {
        return new ResponseEntity<Map>(theaterService.getAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> getOne(long id) {
        return new ResponseEntity<Map>(theaterService.getOne(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> update(Theater theater) {
        return new ResponseEntity<Map>(theaterService.update(theater),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> delete(long id) {
        return new ResponseEntity<Map>(theaterService.delete(id), HttpStatus.OK);
    }
}
