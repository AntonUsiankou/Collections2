package by.gsu.epamlab;

public class Segment {
    private int len;
    private int num;

    public Segment() {
    }

    public Segment(int len) {
        this.len = len;
        num = 1;
    }

    public void fullNum() {
        num++;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + len;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Segment other = (Segment) obj;
        if (len != other.len)
            return false;
        other.num++;
        return true;
    }

    @Override
    public String toString() {
        return len + Constant.SPLITTER + num;
    }

}
