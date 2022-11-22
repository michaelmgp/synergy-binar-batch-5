package com.example.challenge_5.controller;

import com.example.challenge_5.model.Reservation;
import com.example.challenge_5.model.dto.ReservationDTO;
import com.example.challenge_5.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/reservation")
public class ReservationController implements BaseController<Reservation> {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/save-reservation")
    public ResponseEntity<Map> save(@RequestBody ReservationDTO reservationDTO) {
        return new ResponseEntity<Map>(reservationService.saveReservation(reservationDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> save(Reservation reservation) {
        return null;
    }

    @Override
    public ResponseEntity<Map> getAll() {
        return new ResponseEntity<Map>(reservationService.getAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> getOne(long id) {
        return new ResponseEntity<Map>(reservationService.getOne(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> update(Reservation reservation) {
        return new ResponseEntity<Map>(reservationService.update(reservation), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> delete(long id) {
        return new ResponseEntity<Map>(reservationService.delete(id), HttpStatus.OK);
    }
}
