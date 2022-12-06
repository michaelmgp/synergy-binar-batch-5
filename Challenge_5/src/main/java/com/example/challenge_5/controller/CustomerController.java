package com.example.challenge_5.controller;

import com.example.challenge_5.model.security.User;
import com.example.challenge_5.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController implements BaseController<User> {
    @Autowired
    private CustomerService customerService;
    @Override
    public ResponseEntity<Map> save(User customer) {
        return new ResponseEntity<Map>(customerService.save(customer), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> getAll() {
        return new ResponseEntity<Map>(customerService.getAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> getOne(long id) {
        return new ResponseEntity<Map>(customerService.getOne(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> update(User customer) {
        return new ResponseEntity<Map>(customerService.update(customer), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> delete(long id) {
        return new ResponseEntity<Map>(customerService.delete(id), HttpStatus.OK);
    }
}
