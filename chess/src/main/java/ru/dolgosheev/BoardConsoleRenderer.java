package ru.dolgosheev;

import ru.dolgosheev.piece.Piece;

public class BoardConsoleRenderer {

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";

    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";

    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";

    public static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";

    public static final String ANSI_HIGHLIGHTED_SQUARE_BACKGROUND = "\u001B[45m";

    public void render(Board board) {
        for (int rank = 8; rank >= 1; rank--) {
            String line = "";
            for (File file : File.values()) {
                Coordinates coordinates = new Coordinates(file, rank);
                if (board.isSquareEmpty(coordinates)) {
                    line += getSpriteForEmptySquare(coordinates);
                } else {
                    line += getPieceSprite(board.getPiece(coordinates));
                }
            }
            line += ANSI_RESET;
            System.out.println(line);
        }
    }

    private String colorizeSprite(String sprite, Color pieceColor, boolean isSquareDark, boolean isHighLighted) {
        // format = background color + font color + text

        String result = sprite;

        if (pieceColor == Color.WHITE) {
            result = ANSI_WHITE_PIECE_COLOR + result;
        } else {
            result = ANSI_BLACK_PIECE_COLOR + result;
        }

        if (isHighLighted) {
            result = ANSI_HIGHLIGHTED_SQUARE_BACKGROUND;
        } else if (isSquareDark) {
            result = ANSI_BLACK_SQUARE_BACKGROUND + result;
        } else {
            result = ANSI_WHITE_SQUARE_BACKGROUND + result;
        }

        return result;
    }

    private String getSpriteForEmptySquare(Coordinates coordinates) {
//        return colorizeSprite("\u2003\u2003\u2003", Color.WHITE, isSquareDark(coordinates));
        return colorizeSprite("  \u2003", Color.WHITE, isSquareDark(coordinates), true);
    }

    private String selectUnicodeSpriteForPiece(Piece piece) {
        switch (piece.getClass().getSimpleName()) {
            case "Pawn":
                return "♟";

            case "Knight":
                return "♞";

            case "Bishop":
                return "♝";

            case "Rook":
                return "♜";

            case "Queen":
                return "♛";

            case "King":
                return "♚";
        }
        return "";
    }

    private String getPieceSprite(Piece piece) {
//        return colorizeSprite("\u2003" + selectUnicodeSpriteForPiece(piece) + "\u2003", piece.color, isSquareDark(piece.coordinates));
//        return colorizeSprite("\u2003" + selectUnicodeSpriteForPiece(piece) + "\u2003", piece.color, isSquareDark(piece.coordinates));
        return colorizeSprite(" " + selectUnicodeSpriteForPiece(piece) + " ", piece.color, isSquareDark(piece.coordinates), true);
    }

    public static boolean isSquareDark(Coordinates coordinates) {
        return (((coordinates.file.ordinal() + 1) + coordinates.rank) % 2) == 0;
    }
}
