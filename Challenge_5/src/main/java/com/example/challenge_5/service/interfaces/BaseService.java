package com.example.challenge_5.service.interfaces;
import java.util.List;
import java.util.Map;

public interface BaseService <T> {
    Map save(T t);
    Map update(T t);
    Map delete (long id);
    Map getAll();
    Map getOne(long id);
}
