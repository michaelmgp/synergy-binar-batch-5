package com.example.challenge_4.service.base;

import java.util.Map;

public interface BaseUserService<T> {
    Map menambahkanUser(T user);

    Map menghapusUser(long id);

    Map mengubahUser(long id, T t);

    Map mencariSemuaUser();


}
