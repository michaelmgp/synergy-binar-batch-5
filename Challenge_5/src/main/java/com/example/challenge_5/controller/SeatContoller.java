package com.example.challenge_5.controller;

import com.example.challenge_5.controller.BaseController;
import com.example.challenge_5.model.Seat;
import com.example.challenge_5.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/seat")
public class SeatContoller implements BaseController<Seat> {
    @Autowired
    private SeatService service;
    @Override
    public ResponseEntity<Map> save(Seat seat) {
        return new ResponseEntity<Map>(service.save(seat), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> getAll() {
        return new ResponseEntity<Map>(service.getAll(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> getOne(long id) {
        return new ResponseEntity<Map>(service.getOne(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> update(Seat seat) {
        return new ResponseEntity<Map>(service.update(seat), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> delete(long id) {
        return new ResponseEntity<Map>(service.delete(id),HttpStatus.OK);
    }
}
