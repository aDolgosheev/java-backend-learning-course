package ru.dolgosheev.piece;

import ru.dolgosheev.CoordinatesShift;

import java.util.HashSet;
import java.util.Set;

public interface IBishop {

    default Set<CoordinatesShift> getBishopMoves() {
        Set<CoordinatesShift> result = new HashSet<>();

        //bottom-left to top-right
        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;

            result.add(new CoordinatesShift(i, i));
        }

        //bottom-right to top-left
        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;

            result.add(new CoordinatesShift(i, -i));
        }
        return result;
    }
}
