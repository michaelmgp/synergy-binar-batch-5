package com.example.challenge_3.services;

import java.util.List;
import java.util.Map;

public interface RumusInterface {
    public String mean(List<Integer> list);
    public String median(List<Integer> list);
    public String modus(List<Integer> list);
    public Map<String, String> kelompokData(List<Integer> list);
}
