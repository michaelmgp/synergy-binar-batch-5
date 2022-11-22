package com.example.challenge_5.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public interface BaseController <T>{
    @PostMapping("/save")
    ResponseEntity<Map>  save (@RequestBody T t);
    @GetMapping("/get-all")
    ResponseEntity<Map> getAll();
    @GetMapping("/{id}")
    ResponseEntity<Map> getOne(@PathVariable("id") long id);
    @PutMapping("/update")
    ResponseEntity<Map> update(@RequestBody T t);
    @DeleteMapping("/delete/{id}")
    ResponseEntity<Map> delete(@PathVariable("id") long id);

}
