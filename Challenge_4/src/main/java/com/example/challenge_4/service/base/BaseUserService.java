package com.example.challenge_4.service.base;

public interface BaseUserService<T> {
    void menambahkanUser(T user);
    void mengubahUser(T user,long id);
    void mengubahUser(long id);



}
