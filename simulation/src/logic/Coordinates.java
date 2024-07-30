package logic;


import java.util.Objects;

public class Coordinates {

    public final Integer horizontalLine;

    public final Integer verticalLine;

    public Coordinates(Integer horizontalLine, Integer verticalLine) {
        this.horizontalLine = horizontalLine;
        this.verticalLine = verticalLine;
    }

    public Coordinates shift(CoordinatesShift shift) {
        return new Coordinates(this.horizontalLine + shift.horizontalLineShift, this.verticalLine + shift.verticalLineShift);
    }

    public boolean canShift(CoordinatesShift shift) {
        int f = horizontalLine + shift.horizontalLineShift;
        int r = verticalLine + shift.verticalLineShift;
        if ((f < 1) || (f > 10)) return false;
        if ((r < 1) || (r > 10)) return false;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(horizontalLine, that.horizontalLine) && Objects.equals(verticalLine, that.verticalLine);
    }

    @Override
    public int hashCode() {
        int result = horizontalLine.hashCode();
        result = 31 * result + verticalLine.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "(" + horizontalLine + " , " + verticalLine + ")";
    }
}
