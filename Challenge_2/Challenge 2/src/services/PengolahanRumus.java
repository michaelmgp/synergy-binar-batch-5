package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PengolahanRumus extends RumusImpl{

    public Map<String, Object> perhitunganLengkap(List<Integer> listNilai){
        Map<String,Object> nilaiSemuaMap = new HashMap<>();
        nilaiSemuaMap.put("Mean",mean(listNilai));
        nilaiSemuaMap.put("Median", mean(listNilai));
        nilaiSemuaMap.put("Modus", modus(listNilai));
        return nilaiSemuaMap;
    }
}
