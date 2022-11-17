package com.example.challenge_5.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public abstract class Response <T,V,K>{
    public Map error(T code, V status, K obj){
        Map map = new HashMap();
        map.put("code", code);
        map.put("status", status);
        map.put("content",obj );
        return map;
    }

    public Map sukses(T code, V status, K obj ){
        Map map = new HashMap();
        map.put("code",code);
        map.put("status", status);
        map.put("content", obj);
        return  map;
    }
}
