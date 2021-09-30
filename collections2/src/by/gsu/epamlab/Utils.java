package by.gsu.epamlab;

public class Utils {
    public final static String NEW_LINE = System.getProperty("line.separator");

    public static int calcLen(double x1, double x2, double y1, double y2) {
        return (int) Math.round(Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2))));
    }

}