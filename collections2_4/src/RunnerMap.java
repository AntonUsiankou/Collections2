import by.gsu.epamlab.ValueMapComparator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import static by.gsu.epamlab.Constants.*;

public class RunnerMap {
    public static void main(String[] args) {
        Map<Integer, Integer> mapSegments = new HashMap<>();
        try(Scanner scanner = new Scanner(new FileReader(FILE_PATH))){
            while(scanner.hasNext()){
                String [] elements = scanner.nextLine().split(PATTERN_REG_EXP);
                Integer len = calculateLen(elements);
                Integer numberSegment = mapSegments.get(len);
                if (numberSegment == null) {
                    numberSegment = 0;
                }
                mapSegments.put(len, numberSegment + 1);
            }
            SortedMap<Integer, Integer> sortedMapNumLen =
                    new TreeMap<Integer,Integer>(new ValueMapComparator(mapSegments));
            sortedMapNumLen.putAll(mapSegments);
            for(Map.Entry<Integer, Integer> segment : sortedMapNumLen.entrySet()){
                System.out.println(segment.getKey() + SPLITTER + segment.getValue());
            }

        }catch(FileNotFoundException e){
            System.err.println(ERROR_MESSAGE);
        }

    }

    private static int calculateLen (String [] elements){
        double x1 = Double.parseDouble(elements[X1_POSITION]);
        double x2 = Double.parseDouble(elements[X2_POSITION]);
        double y1 = Double.parseDouble(elements[Y1_POSITION]);
        double y2 = Double.parseDouble(elements[Y2_POSITION]);
        double dx = x1 - x2;
        double dy = y1 - y2;
        return (int) Math.round(Math.sqrt((dx * dx) + (dy * dy)));
    }

}
