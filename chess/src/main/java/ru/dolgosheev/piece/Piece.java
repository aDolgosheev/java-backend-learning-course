package ru.dolgosheev.piece;

import ru.dolgosheev.Color;
import ru.dolgosheev.Coordinates;

public abstract class Piece {

    public final Color color;

    public Coordinates coordinates;

    public Piece(Color color, Coordinates coordinates) {
        this.color = color;
        this.coordinates = coordinates;
    }
}
