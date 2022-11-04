package com.example.challenge_4.service.base;

import java.util.Map;

public interface BaseUserService<T> {
    Map menambahkanUser(T user);
    Map mengubahUser(T user,long id);
    Map menghapusUser(long id);



}
