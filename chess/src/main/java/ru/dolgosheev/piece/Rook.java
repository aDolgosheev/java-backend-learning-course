package ru.dolgosheev.piece;

import ru.dolgosheev.*;

import java.util.Set;

public class Rook extends LongRangePiece implements IRook {

    public Rook(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return getRookMoves();
    }
}
