package services;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RumusImpl implements InterfaceRumus {
    @Override
    public double mean(List<Integer> list) {
        int totalNilai = 0;
        for(int i:list){
            totalNilai+=i;
        }
        return totalNilai/list.size();
    }

    @Override
    public double median(List<Integer> list) {
        int len = list.size();
        Collections.sort(list);
        if (len % 2 != 0)
            return (double)list.get(len/2);

        return (double) (list.get((len-1)/2)+list.get(len/2))/2.0;

    }

    @Override
    public int modus(List<Integer> list) {
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
        return maxValue;
    }


    @Override
    public Map<Integer, Integer> kelompokData(List<Integer> list) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(Integer i : list){
            Integer count = frequencyMap.get(i);
            if (count==null){
                count=0;
            }
            frequencyMap.put(i,count+1);
        }
        return frequencyMap;
    }
}
