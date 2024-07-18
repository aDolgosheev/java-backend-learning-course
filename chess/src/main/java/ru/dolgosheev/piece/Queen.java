package ru.dolgosheev.piece;

import ru.dolgosheev.Color;
import ru.dolgosheev.Coordinates;
import ru.dolgosheev.CoordinatesShift;

import java.util.Set;

public class Queen extends LongRangePiece implements IRook, IBishop {

    public Queen(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> moves = getBishopMoves();
        moves.addAll(getRookMoves());

        return moves;
    }
}
