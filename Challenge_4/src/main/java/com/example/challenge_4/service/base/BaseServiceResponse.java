package com.example.challenge_4.service.base;

import java.util.Map;

public interface BaseServiceResponse <T> extends BaseService<T>{
    Map save(T t);
    Map update(long id, T t);
    Map delete(long id);
    Map getById(long id);
    Map getAll();
}
