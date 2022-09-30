package services;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface InterfaceRumus {
    public String mean(List<Integer> list);
    public String median(List<Integer> list);
    public String modus(List<Integer> list);
    public Map<String, String> kelompokData(List<Integer> list);
}
