package com.example.challenge_4.controller;
import com.example.challenge_4.controller.base.BaseController;
import com.example.challenge_4.model.Customer;
import com.example.challenge_4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/customer")
public class UserController implements BaseController<Customer> {
    @Autowired
    private CustomerService customerService;
    @Override
    @PostMapping("/save")
    public ResponseEntity<Map> save(Customer customer) {
        return new ResponseEntity<Map>(customerService.menambahkanUser(customer), HttpStatus.OK);
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<Map> update(@RequestBody Customer customer,@PathVariable("id") long id) {
        return new ResponseEntity<Map>(customerService.mengubahUser(id, customer),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<Map>(customerService.menghapusUser(id), HttpStatus.OK);
    }

    @Override
    @GetMapping("/find-all")
    public ResponseEntity<Map> findAll() {
        return new ResponseEntity<Map>(customerService.mencariSemuaUser(),HttpStatus.OK);
    }
}