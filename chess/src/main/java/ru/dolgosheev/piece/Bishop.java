package ru.dolgosheev.piece;

import ru.dolgosheev.Color;
import ru.dolgosheev.Coordinates;
import ru.dolgosheev.CoordinatesShift;

import java.util.Set;

public class Bishop extends LongRangePiece implements IBishop {

    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return getBishopMoves();
    }
}
