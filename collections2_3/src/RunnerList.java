import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class RunnerList {

    private static final String FILE_PATH = "src/in.txt";
    private static final String PATTERN_REG_EXP = "[\\s(;)]+";

    private static final int X1_POSITION = 1;
    private static final int Y1_POSITION = 2;
    private static final int X2_POSITION = 3;
    private static final int Y2_POSITION = 4;
    private static final String SPLITTER = ";";

    private static final String ERROR_MESSAGE = "File not found";
    public static void main(String[] args) {
        Map<Integer, Integer> mapSegments = new HashMap<>();
        try(Scanner scanner = new Scanner(new FileReader(FILE_PATH))){
            while(scanner.hasNext()){
                String [] elements = scanner.nextLine().split(PATTERN_REG_EXP);
                Integer len = calculateLen(elements);
                Integer numberSegment = mapSegments.get(len);
                mapSegments.put(len,numberSegment == null ? 1 : ++numberSegment);
            }

            List<Map.Entry<Integer,Integer>> extraSegment = new ArrayList<>(mapSegments.entrySet());
            Collections.sort(extraSegment, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });

            for(Map.Entry<Integer, Integer> segment : extraSegment){
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
