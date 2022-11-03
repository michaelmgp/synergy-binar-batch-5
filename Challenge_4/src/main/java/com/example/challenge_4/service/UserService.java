package com.example.challenge_4.service;

import com.example.challenge_4.model.Customer;
import com.example.challenge_4.service.base.BaseUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements BaseUserService<Customer> {
    @Override
    public void menambahkanUser(Customer user) {

    }

    @Override
    public void mengubahUser(Customer user, long id) {

    }

    @Override
    public void mengubahUser(long id) {

    }
}
