import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RunnerList {

    private static final String FILE_PATH = "src/in.txt";
    private static final String PATTERN_REG_EXP = "[\\s(;)]+";

    private static final int X1_POSITION = 1;
    private static final int Y1_POSITION = 2;
    private static final int X2_POSITION = 3;
    private static final int Y2_POSITION = 4;
    private static final int NULL = 0;
    private static final int ONE = 1;

    private static final String ERROR_MESSAGE = "File not found";
    private static final String SEPARATOR = ";";
    public static void main(String[] args) {
        List <Integer> lenList = new ArrayList<>();
        List <Integer> numList = new ArrayList<>();
        try(Scanner scanner = new Scanner(new FileReader(FILE_PATH))){
            while(scanner.hasNext()){
                String [] elements = Pattern.compile(PATTERN_REG_EXP).split(scanner.nextLine());
                double x1 = Double.parseDouble(elements[X1_POSITION]);
                double x2 = Double.parseDouble(elements[X2_POSITION]);
                double y1 = Double.parseDouble(elements[Y1_POSITION]);
                double y2 = Double.parseDouble(elements[Y2_POSITION]);
                int len = (int) Math.round(Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2))));

                int index = Collections.binarySearch(lenList, len);
                if(index >= NULL){
                    numList.set(index, numList.get(index) + ONE);
                }else{
                    lenList.add(-index - ONE, len);
                    numList.add(-index - ONE, ONE);
                }

            }
        }catch(FileNotFoundException e){
            System.err.println(ERROR_MESSAGE);
        }
        print(lenList, numList);
    }
    private static void print(List<Integer> lenList, List<Integer> numList){
        sort(lenList, numList);
        for (int i = NULL; i < lenList.size(); i++){
            System.out.println(lenList.get(i) + SEPARATOR + numList.get(i));
        }
    }

    private static void sort(List<Integer> lenList, List<Integer> numList){
        for (int i = NULL; i < lenList.size(); i++){
            for(int j = numList.size() - ONE; j > i; j--){
                if(numList.get(j) > numList.get(j - ONE)){
                    int tmp = numList.get(j);
                    numList.set(j, numList.get(j - ONE));
                    numList.set(j - ONE, tmp);

                    tmp = lenList.get(j);
                    lenList.set(j, lenList.get(j - ONE));
                    lenList.set(j - ONE, tmp);
                }
            }
        }
    }
}
