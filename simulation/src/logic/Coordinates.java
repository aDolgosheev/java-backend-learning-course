package logic;


import java.util.Objects;

public class Coordinates {

    public final Integer file;

    public final Integer rank;

    public Coordinates(Integer file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }

    public Coordinates shift(CoordinatesShift shift) {
        return new Coordinates(this.file + shift.fileShift, this.rank + shift.rankShift);
    }

    public boolean canShift(CoordinatesShift shift) {
        int f = file + shift.fileShift;
        int r = rank + shift.rankShift;
        if ((f < 1) || (f > 10)) return false;
        if ((r < 1) || (r > 10)) return false;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(file, that.file) && Objects.equals(rank, that.rank);
    }

    @Override
    public int hashCode() {
        int result = file.hashCode();
        result = 31 * result + rank.hashCode();
        return result;
    }
}
