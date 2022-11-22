package com.example.challenge_5.controller;

import com.example.challenge_5.model.Screening;
import com.example.challenge_5.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/screening")
public class ScreeningController implements BaseController<Screening> {
    @Autowired
    private ScreeningService service;
    @Override
    public ResponseEntity<Map> save(Screening screening) {
        return new ResponseEntity<Map>(service.save(screening), HttpStatus.OK);
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
    public ResponseEntity<Map> update(Screening screening) {
        return new ResponseEntity<Map>(service.update(screening), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> delete(long id) {
        return new ResponseEntity<Map>(service.delete(id), HttpStatus.OK);
    }
}
