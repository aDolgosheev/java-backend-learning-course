package ru.dolgosheev.piece;

import ru.dolgosheev.Board;
import ru.dolgosheev.Color;
import ru.dolgosheev.Coordinates;
import ru.dolgosheev.CoordinatesShift;

import java.util.HashSet;
import java.util.Set;

public class Bishop extends Piece {

    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
//        return Set.of();

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

    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
        boolean result = super.isSquareAvailableForMove(coordinates, board);

        if (result) {

            //

        }

        return false;
    }
}
