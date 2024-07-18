package ru.dolgosheev.piece;

import ru.dolgosheev.Color;
import ru.dolgosheev.Coordinates;
import ru.dolgosheev.CoordinatesShift;

import java.util.HashSet;
import java.util.Set;

public class Rook extends Piece {

    public Rook(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> result = new HashSet<>();

        //left to right
        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;

            result.add(new CoordinatesShift(i, 0));
        }

        //bottom to top
        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;

            result.add(new CoordinatesShift(0, i));
        }

        return result;
    }
}
