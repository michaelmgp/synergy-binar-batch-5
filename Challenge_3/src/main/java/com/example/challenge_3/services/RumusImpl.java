package com.example.challenge_3.services;

import java.util.*;
import java.util.stream.Collectors;

public class RumusImpl implements RumusInterface{
    @Override
    public String mean(List<Integer> list) {

        Integer sum = list.stream().collect(Collectors.summingInt(Integer::intValue));
        double mean = ((double)sum/ list.size());
        String meanNilai = Double.toString(mean);
        return meanNilai;
    }

    @Override
    public String median(List<Integer> list) {
        double median =list.stream().sorted().skip(Math.max(0, ((list.size() + 1) / 2) - 1))
                .limit(1 + (1 + list.size()) % 2).mapToInt(Integer::intValue).average().getAsDouble();
        String stringNilaiMedian =  Double.toString(median);
        return stringNilaiMedian;
    }

    @Override
    public String modus(List<Integer> list) {
         Integer mode = list.stream()
                .collect(Collectors.groupingBy(i -> i, () -> new TreeMap<Integer, Long>(), Collectors.counting()))
                .entrySet().stream().sorted((a, b) -> {
                    if (!a.getValue().equals(b.getValue()))
                        return b.getValue().compareTo(a.getValue());
                    return a.getKey().compareTo(b.getKey());
                }).findFirst().get().getKey();

        return Integer.toString(mode);

    }

    @Override
    public Map<String, String> kelompokData(List<Integer> list) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Map<String, String> newFrequencyMap= new HashMap<>();
        for(Integer i : list){
            Integer count = frequencyMap.get(i);
            if (count==null){
                count=0;
            }
            frequencyMap.put(i,count+1);
        }
        for(Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()){
            newFrequencyMap.put(entry.getKey().toString(),entry.getValue().toString());
        }
        return newFrequencyMap;
    }
}
