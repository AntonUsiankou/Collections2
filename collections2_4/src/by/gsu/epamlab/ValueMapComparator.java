package by.gsu.epamlab;

import java.util.Comparator;
import java.util.Map;

import static by.gsu.epamlab.Constants.NUMBER_NULL;
import static by.gsu.epamlab.Constants.NUMBER_ONE;

public class ValueMapComparator implements Comparator<Integer> {
    private Map<Integer, Integer> baseMap;
    public ValueMapComparator(Map<Integer, Integer> baseMap) {
        this.baseMap = baseMap;
    }
    @Override
    public int compare(Integer num0, Integer num1) {
        int diff = baseMap.get(num1) - baseMap.get(num0);
        if(diff != NUMBER_NULL) {
            return diff;
        } else {
            return NUMBER_ONE;
        }
    }
}

