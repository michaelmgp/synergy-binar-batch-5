package com.example.challenge_5.controller;
import com.example.challenge_5.model.SeatReserved;
import com.example.challenge_5.service.SeatReservedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/seat-reserved")
public class SeatReservedController implements BaseController<SeatReserved> {
    @Autowired
    private SeatReservedService service;
    @Override
    public ResponseEntity<Map> save(SeatReserved seatReserved) {
        return new ResponseEntity<Map>(service.save(seatReserved), HttpStatus.OK);
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
    public ResponseEntity<Map> update(SeatReserved seatReserved) {
        return new ResponseEntity<Map>(service.update(seatReserved), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> delete(long id) {
        return new ResponseEntity<Map>(service.delete(id), HttpStatus.OK);
    }
}
