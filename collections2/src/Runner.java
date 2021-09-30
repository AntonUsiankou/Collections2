import by.gsu.epamlab.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static by.gsu.epamlab.Constants.*;

public class Runner {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new FileReader(FILE_PATH));) {
            List<LenNum> list = new ArrayList<>();
            LenNum lenNum;
            while (scanner.hasNext()) {
                String[] elements = Pattern.compile(PATTERN).split(scanner.nextLine());
                double x1 = Double.parseDouble(elements[POSITION_X1]);
                double y1 = Double.parseDouble(elements[POSITION_Y1]);
                double x2 = Double.parseDouble(elements[POSITION_X2]);
                double y2 = Double.parseDouble(elements[POSITION_Y2]);
                lenNum = new LenNum(Utils.calcLen(x1, x2, y1, y2));

                int index = Collections.binarySearch(list, lenNum);
                if (index >= NULL) {
                    list.get(index).incNum();
                } else {
                    list.add(-index - ONE, lenNum);
                }
            }
            Collections.sort(list, new NumComparator());
            list.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            System.err.println(FILE_NOT_FOUND);
        }
    }
}