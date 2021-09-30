package by.gsu.epamlab;

public class LenNum implements Comparable<LenNum> {

    private final int len;
    private int num;

    public LenNum(int len) {
        this.len = len;
        num = 1;
    }

    public int getNum() {
        return num;
    }

    public void incNum() {
        num++;
    }

    @Override
    public String toString() {
        return len + ";" + num;
    }

    @Override
    public int compareTo(LenNum o) {
        return len - o.len;
    }
}