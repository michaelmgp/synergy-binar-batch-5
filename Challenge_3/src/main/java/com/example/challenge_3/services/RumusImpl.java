package com.example.challenge_3.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RumusImpl implements RumusInterface{
    @Override
    public String mean(List<Integer> list) {
        int totalNilai = 0;
        for(int i:list){
            totalNilai+=i;
        }

        String meanNilai = Double.toString(totalNilai/list.size());
        return meanNilai;
    }

    @Override
    public String median(List<Integer> list) {
        int len = list.size();
        double medianNilai = 0.0;
        Collections.sort(list);
        if (len % 2 != 0){
            medianNilai=(double)list.get(len/2);
            return Double.toString(medianNilai);
        }
        medianNilai = (double) (list.get((len-1)/2)+list.get(len/2))/2.0;
        String stringNilaiMedian =  Double.toString(medianNilai);
        return stringNilaiMedian;
    }

    @Override
    public String modus(List<Integer> list) {
        int maxValue = 0, maxCount = 0, i,j;
        int n = list.size();
        for (i = 0; i < n; ++i) {
            int count = 0;
            for (j = 0; j < n; ++j) {
                if (list.get(j) == list.get(i))
                    ++count;
            }

            if (count > maxCount) {
                maxCount = count;
                maxValue = list.get(i);
            }
        }

        return Integer.toString(maxValue);

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
