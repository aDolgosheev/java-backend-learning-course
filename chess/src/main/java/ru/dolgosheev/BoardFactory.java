package ru.dolgosheev;

import ru.dolgosheev.piece.Pawn;
import ru.dolgosheev.piece.PieceFactory;

public class BoardFactory {

    private PieceFactory pieceFactory = new PieceFactory();

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
//                    board.setPiece(coordinates, new Pawn(Color.WHITE, coordinates));
                    board.setPiece(coordinates, pieceFactory.fromFenCharH(fenChar, coordinates));
                    fileIndex++;
                }
            }
        }
        return board;
    }
}
