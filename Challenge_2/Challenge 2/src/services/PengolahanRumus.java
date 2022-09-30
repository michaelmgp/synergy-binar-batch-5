package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PengolahanRumus extends RumusImpl{

    public Map<String, String> perhitunganLengkap(List<Integer> listNilai){
        Map<String,String> nilaiSemuaMap = new HashMap<>();
        nilaiSemuaMap.put("Mean",mean(listNilai));
        nilaiSemuaMap.put("Median", mean(listNilai));
        nilaiSemuaMap.put("Modus", modus(listNilai));
        return nilaiSemuaMap;
    }
}
