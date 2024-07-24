package ru.dolgosheev;

import ru.dolgosheev.board.Board;
import ru.dolgosheev.board.BoardConsoleRenderer;
import ru.dolgosheev.board.Move;

public class Game {

    private final Board board;

    private BoardConsoleRenderer renderer = new BoardConsoleRenderer();

    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop() {
        boolean isWhiteToMove = true;

        while (true) {
            // render
            renderer.render(board);

            if (isWhiteToMove) {
                System.out.println("White to move");
            } else {
                System.out.println("Black to move");
            }

            Move move = InputCoordinates.inputMove(board, isWhiteToMove ? Color.WHITE : Color.BLACK, renderer);

            // make move
            board.makeMove(move);

            // pass move
            isWhiteToMove =! isWhiteToMove;
        }
    }
}
