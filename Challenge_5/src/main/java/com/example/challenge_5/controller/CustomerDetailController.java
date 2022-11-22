package com.example.challenge_5.controller;

import com.example.challenge_5.model.CustomerDetail;
import com.example.challenge_5.service.CustomerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/customer-detail")
public class CustomerDetailController implements BaseController<CustomerDetail> {
    @Autowired
    private CustomerDetailService service;
    @Override
    public ResponseEntity<Map> save(CustomerDetail customerDetail) {
        return new ResponseEntity<Map>(service.save(customerDetail), HttpStatus.OK);
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
    public ResponseEntity<Map> update(CustomerDetail customerDetail) {
        return new ResponseEntity<Map>(service.update(customerDetail), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map> delete(long id) {
        return new ResponseEntity<Map>(service.delete(id), HttpStatus.OK);
    }
}
