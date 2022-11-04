package com.example.challenge_4.controller.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface BaseController<T> {
    ResponseEntity<Map> save(@RequestBody T t);
    ResponseEntity<Map> update(@RequestBody T t, long id);
    ResponseEntity<Map> delete(Long id);

    ResponseEntity<Map> findAll();
}
