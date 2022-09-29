package services;

import java.util.List;
import java.util.Map;

public interface InterfaceRumus {
    public double mean(List<Integer> list);
    public double median(List<Integer> list);
    public int modus(List<Integer> list);
    public Map<Integer,Integer> kelompokData(List<Integer> list);
}
