package ru.dolgosheev;

import ru.dolgosheev.piece.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        Board board = new Board();
//        board.setupDefaultPiecesPositions();

//        Board board = new BoardFactory().fromFEN(
//                "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"
//        );
        Board board = new BoardFactory().fromFEN(
                "8/3p2P1/5n2/2N5/3B4/6P1/8/8 w - - 0 1"
        );
        BoardConsoleRenderer boardConsoleRenderer = new BoardConsoleRenderer();
//
//        Piece piece = board.getPiece(new Coordinates(File.B, 1));
//        Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);

        Game game = new Game(board);
        game.gameLoop();

    }
}