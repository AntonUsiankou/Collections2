import by.gsu.epamlab.Point;

import by.gsu.epamlab.Segment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import static by.gsu.epamlab.Constant.*;

public class Runner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader(FILE_PATH))) {
            Set<Segment> segments = new HashSet<>();
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(PATTERN);
                Point firstPoint = new Point(Double.parseDouble(line[INDEX_ONE]), Double.parseDouble(line[INDEX_TWO]));
                Point secondPoint = new Point(Double.parseDouble(line[INDEX_THREE]), Double.parseDouble(line[INDEX_FOUR]));

                Segment keySegment = new Segment(distance(firstPoint, secondPoint));
                segments.add(keySegment);
            }

            List<Segment> extraSegment = new ArrayList<>(segments);
            Collections.sort(extraSegment, new Comparator<Segment>() {
                @Override
                public int compare(Segment o1, Segment o2) {
                    return o2.getNum() - o1.getNum();
                }
            });

            for (Segment segment : extraSegment) {
                System.out.println(segment);
            }

        } catch (FileNotFoundException e) {
            System.err.println(ERROR_FILE_MESSAGE);
        }
    }

    private static int distance(Point one, Point two) {
        double dx = one.getX() - two.getX();
        double dy = one.getY() - two.getY();
        return (int) Math.round(Math.sqrt(pow(dx, TWO) + pow(dy, TWO)));
    }

    private static double pow(double value, int d) {
        double result = ONE;
        for (int i = ONE; i <= d; i++) {
            result = result * value;
        }
        return result;
    }
}
