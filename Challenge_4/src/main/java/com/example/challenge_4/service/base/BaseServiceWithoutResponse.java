package com.example.challenge_4.service.base;

import java.util.List;

public interface BaseServiceWithoutResponse<T> {
    void save(T t);
    void delete(long id);
    void update(long id, T t);
    T getById (long id);
    List<T> getAll();
}
