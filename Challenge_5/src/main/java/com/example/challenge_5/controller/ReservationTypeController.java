package com.example.challenge_5.controller;

import com.example.challenge_5.model.ReservationType;
import com.example.challenge_5.service.ReservationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/reservation-type")
public class ReservationTypeController implements BaseController<ReservationType> {
    @Autowired
    private ReservationTypeService service;
    @Override
    public ResponseEntity<Map> save(ReservationType reservationType) {
        return new ResponseEntity<Map>(service.save(reservationType), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> getAll() {
        return new ResponseEntity<Map>(service.getAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> getOne(long id) {
        return new ResponseEntity<Map>(service.getOne(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> update(ReservationType reservationType) {
        return new ResponseEntity<Map>(service.update(reservationType), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> delete(long id) {
        return new ResponseEntity<Map>(service.delete(id), HttpStatus.OK);
    }
}
