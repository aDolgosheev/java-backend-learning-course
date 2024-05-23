package ru.dolgosheev.piece;

import ru.dolgosheev.Board;
import ru.dolgosheev.Color;
import ru.dolgosheev.Coordinates;
import ru.dolgosheev.File;

public class BoardFactory {

    public Board fromFEN(String fen) {
        Board board = new Board();
        String[] parts = fen.split(" ");
        String piecePositions = parts[0];
        String[] fenRows = piecePositions.split("/");

        for (int i = 0; i < fenRows.length; i++) {
            String row = fenRows[i];
            int rank = 8 - i;

            int fileIndex = 0;
            for (int j = 0; j < row.length(); j++) {
                char fenChar = row.charAt(j);

                if (Character.isDigit(fenChar)) {
                    fileIndex += Character.getNumericValue(fenChar);
                } else {
                    File file = File.values()[fileIndex];
                    Coordinates coordinates = new Coordinates(file, rank);
                    board.setPiece(coordinates, new Pawn(Color.WHITE, coordinates));
                }
            }
        }
        return board;
    }
}
